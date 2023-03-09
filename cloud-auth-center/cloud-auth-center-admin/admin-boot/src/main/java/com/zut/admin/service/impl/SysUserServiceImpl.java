package com.zut.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zut.admin.dto.UserAuthDTO;
import com.zut.admin.mapper.SysUserMapper;
import com.zut.admin.pojo.entity.SysUser;
import com.zut.admin.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Date 2023-03-09 11:10 星期四
 * @Author: 聂建强
 * @Description:
 */

@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {


    @Override
    public UserAuthDTO getByUsername(String username) {
        UserAuthDTO userAuthInfo = this.baseMapper.getByUsername(username);
        return userAuthInfo;
    }
}
