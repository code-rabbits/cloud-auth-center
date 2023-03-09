package com.zut.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zut.admin.dto.UserAuthDTO;
import com.zut.admin.pojo.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * @Date 2023-03-09 11:01 星期四
 * @Author: 聂建强
 * @Description:
 */

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    UserAuthDTO getByUsername(@Param("userName") String userName);
}
