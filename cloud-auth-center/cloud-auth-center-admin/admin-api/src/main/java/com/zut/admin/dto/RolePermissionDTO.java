package com.zut.admin.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Date 2023-03-09 10:43 星期四
 * @Author: 聂建强
 * @Description:  角色权限DTO
 */

@Data
@Accessors(chain = true)
public class RolePermissionDTO {

    private Long roleId;
    private List<Long> permissionIds;
    private Long menuId;

}
