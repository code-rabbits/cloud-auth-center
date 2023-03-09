package com.zut.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zut.admin.dto.MemberUserAuthDTO;
import com.zut.admin.mapper.MemberUserMapper;
import com.zut.admin.pojo.entity.MemberUser;
import com.zut.admin.service.MemberUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Date 2023-03-09 11:14 星期四
 * @Author: 聂建强
 * @Description:
 */

@Service
@RequiredArgsConstructor
public class MemberUserServiceImpl extends ServiceImpl<MemberUserMapper, MemberUser> implements MemberUserService {
    @Override
    public MemberUserAuthDTO getByUsername(String username) {
        MemberUserAuthDTO memberUserAuthDTO = this.baseMapper.getByUsername(username);
        return memberUserAuthDTO;
    }
}
