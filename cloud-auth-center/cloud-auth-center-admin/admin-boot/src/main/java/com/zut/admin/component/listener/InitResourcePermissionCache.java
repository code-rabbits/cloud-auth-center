package com.zut.admin.component.listener;

import com.zut.admin.service.SysPermissionService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Date 2023-03-09 10:53 星期四
 * @Author: 聂建强
 * @Description:  初始化角色权限，主要是给网关使用
 */

@Component
@AllArgsConstructor
public class InitResourcePermissionCache implements CommandLineRunner {

    private SysPermissionService sysPermissionService;

    @Override
    public void run(String... args) throws Exception {

        sysPermissionService.refreshPermRolesRules();
    }
}
