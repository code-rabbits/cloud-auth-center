package com.zut.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zut.admin.pojo.entity.SysPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Date 2023-03-09 11:02 星期四
 * @Author: 聂建强
 * @Description:
 */

@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    List<SysPermission> listPermRoles();
}
