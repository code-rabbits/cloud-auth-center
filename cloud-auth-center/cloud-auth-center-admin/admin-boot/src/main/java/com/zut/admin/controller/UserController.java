package com.zut.admin.controller;

import com.zut.admin.dto.MemberUserAuthDTO;
import com.zut.admin.dto.UserAuthDTO;
import com.zut.admin.service.MemberUserService;
import com.zut.admin.service.SysUserService;
import com.zut.common.base.result.R;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2023-03-09 11:15 星期四
 * @Author: 聂建强
 * @Description:  获取用户信息
 */

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final SysUserService sysUserService;

    private final MemberUserService memberUserService;

    /**
     * 获取用户信息
     */
    @GetMapping("/username/{username}")
    public R<UserAuthDTO> getUserByUsername(@PathVariable String username) {
        UserAuthDTO user = sysUserService.getByUsername(username);
        return R.ok(user);
    }
    /**
     * 获取会员用户信息
     */
    @GetMapping("/member/username/{username}")
    public R<MemberUserAuthDTO> getMemberUserByUsername(@PathVariable String username) {
        log.info("获取member user info。。。");
        MemberUserAuthDTO user = memberUserService.getByUsername(username);
        return R.ok(user);
    }
}
