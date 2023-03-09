package com.zut.admin.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.bean.BeanUtil;
import com.zut.admin.dto.OAuth2ClientDTO;
import com.zut.admin.pojo.entity.SysOauthClient;
import com.zut.admin.service.SysOauthClientService;
import com.zut.common.base.result.R;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2023-03-09 11:17 星期四
 * @Author: 聂建强
 * @Description:   获取客户端信息
 */

@RequestMapping("/api/oauth-clients")
@Slf4j
@AllArgsConstructor
@RestController
public class OauthClientController {


    private SysOauthClientService sysOauthClientService;

    @GetMapping("/getOAuth2ClientById")
    public R<OAuth2ClientDTO> getOAuth2ClientById(@RequestParam String clientId) {
        SysOauthClient client = sysOauthClientService.getById(clientId);
        Assert.notNull(client, "OAuth2 客户端不存在");
        OAuth2ClientDTO oAuth2ClientDTO = new OAuth2ClientDTO();
        BeanUtil.copyProperties(client, oAuth2ClientDTO);
        return R.ok(oAuth2ClientDTO);
    }
}
