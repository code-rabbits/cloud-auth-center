package com.zut.admin.api;

import com.zut.admin.dto.OAuth2ClientDTO;
import com.zut.common.base.result.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Date 2023-03-09 10:39 星期四
 * @Author: 聂建强
 * @Description:
 */

@FeignClient(value = "cloud-auth-center-admin", contextId = "oauth-client")
public interface OAuthClientFeignClient {

    @GetMapping("/api/oauth-clients/getOAuth2ClientById")
    R<OAuth2ClientDTO> getOAuth2ClientById(@RequestParam String clientId);

}
