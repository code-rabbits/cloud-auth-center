package com.zut.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zut.admin.dto.MemberUserAuthDTO;
import com.zut.admin.pojo.entity.MemberUser;
import com.zut.admin.dto.UserAuthDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * @Date 2023-03-09 11:03 星期四
 * @Author: 聂建强
 * @Description:
 */
@Mapper
public interface MemberUserMapper extends BaseMapper<MemberUser> {

    MemberUserAuthDTO getByUsername(@Param("userName") String userName);
}
