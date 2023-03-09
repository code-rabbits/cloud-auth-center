package com.zut.auth.security.details.user;

import com.zut.admin.api.UserFeignClient;
import com.zut.admin.dto.UserAuthDTO;
import com.zut.auth.common.enums.PasswordEncoderTypeEnum;
import com.zut.common.base.result.R;
import com.zut.common.base.result.ResultCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * @Date 2023-03-08 20:42 星期三
 * @Author: 聂建强
 * @Description:  自定义 UserDetailsService
 */

@Service("sysUserDetailsService")
@Slf4j
@RequiredArgsConstructor
public class SysUserDetailsServiceImpl implements UserDetailsService {

    private final UserFeignClient userFeignClient;


    /**
     * 自定义登录逻辑
     * @param username   用户名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // // 后面从客户端获取用户信息
        // SysUserDetails userDetails=loadUser(username);
        // if (!userDetails.isEnabled()){
        //     throw new DisabledException("该账户已被禁用！");
        // } else if (!userDetails.isAccountNonLocked()) {
        //     throw new LockedException("该账户已被禁用！");
        // }else if (!userDetails.isAccountNonExpired()){
        //     throw new AccountExpiredException("该账号已过期!");
        // }
        //
        // return userDetails;


        R<UserAuthDTO> result = userFeignClient.getUserByUsername(username);
        SysUserDetails userDetails = null;
        if (R.ok().getCode().equals(result.getCode())) {
            UserAuthDTO user = result.getData();
            if (null != user) {
                userDetails = SysUserDetails.builder()
                        .userId(user.getUserId())
                        .username(user.getUsername())
                        .authorities(handleRoles(user.getRoles()))
                        .enabled(user.getStatus() == 1)
                        .password(PasswordEncoderTypeEnum.BCRYPT.getPrefix() + user.getPassword())
                        .build();
            }
        }
        if (Objects.isNull(userDetails)) {
            throw new UsernameNotFoundException(ResultCode.USER_NOT_EXIST.getMsg());
        } else if (!userDetails.isEnabled()) {
            throw new DisabledException("该账户已被禁用!");
        } else if (!userDetails.isAccountNonLocked()) {
            throw new LockedException("该账号已被锁定!");
        } else if (!userDetails.isAccountNonExpired()) {
            throw new AccountExpiredException("该账号已过期!");
        }
        return userDetails;

    }


    // /**
    //  * 获取用户
    //  * @param username
    //  * @return
    //  */
    // private SysUserDetails loadUser(String username){
    //     Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
    //     authorities.add(new SimpleGrantedAuthority("admin"));
    //     return SysUserDetails.builder()
    //             .userId(1L)
    //             .username(username)
    //             .enabled(true)
    //             .authorities(authorities)
    //             .password(PasswordEncoderTypeEnum.BCRYPT.getPrefix()+new BCryptPasswordEncoder().encode("123456")).build();
    // }


    private Collection<SimpleGrantedAuthority> handleRoles(List<String> roles) {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }


}
