package com.zut.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zut.admin.pojo.entity.SysPermission;

import java.util.List;

/**
 * @Date 2023-03-09 11:08 星期四
 * @Author: 聂建强
 * @Description:
 */
public interface SysPermissionService extends IService<SysPermission> {

    /**
     * 刷新Redis缓存中角色菜单的权限规则，角色和菜单信息变更调用
     */
    boolean refreshPermRolesRules();

    List<SysPermission> listPermRoles();
}
