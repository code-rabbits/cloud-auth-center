package com.zut.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zut.admin.dto.UserAuthDTO;
import com.zut.admin.pojo.entity.SysUser;

/**
 * @Date 2023-03-09 11:07 星期四
 * @Author: 聂建强
 * @Description:
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 根据用户名获取认证用户信息，携带角色和密码
     *
     * @param username
     * @return
     */
    UserAuthDTO getByUsername(String username);



}
