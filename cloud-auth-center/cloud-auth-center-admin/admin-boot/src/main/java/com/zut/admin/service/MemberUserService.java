package com.zut.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zut.admin.dto.MemberUserAuthDTO;
import com.zut.admin.pojo.entity.MemberUser;

/**
 * @Date 2023-03-09 11:09 星期四
 * @Author: 聂建强
 * @Description:
 */
public interface MemberUserService extends IService<MemberUser> {

    /**
     * 根据用户名获取认证用户信息，携带角色和密码
     *
     * @param username
     * @return
     */
    MemberUserAuthDTO getByUsername(String username);

}
