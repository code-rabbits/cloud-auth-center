package com.zut.auth.security.details.client;

import com.zut.admin.api.OAuthClientFeignClient;
import com.zut.admin.dto.OAuth2ClientDTO;
import com.zut.auth.common.enums.PasswordEncoderTypeEnum;
import com.zut.common.base.result.R;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

/**
 * @Date 2023-03-08 20:59 星期三
 * @Author: 聂建强
 * @Description:  自定义客户端 ClientDetailsService
 */

@Service
@RequiredArgsConstructor
public class ClientDetailsServiceImpl implements ClientDetailsService {

    private final OAuthClientFeignClient oAuthClientFeignClient;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        // // 后面通过feign从客户端获取，目前写死
        // BaseClientDetails clientDetails=new BaseClientDetails(
        //         "ams",
        //         "",
        //         "all",
        //         "password,client_credentials,refresh_token,authorization_code",
        //         "",
        //         "http://www.baidu.com/"
        // );
        //
        // clientDetails.setClientSecret(PasswordEncoderTypeEnum.NOOP.getPrefix() + "ams");
        // clientDetails.setAccessTokenValiditySeconds(3600);
        // clientDetails.setRefreshTokenValiditySeconds(36000000);
        // return clientDetails;

        // 通过feign 调用admin服务获取client信息
        R<OAuth2ClientDTO> result = oAuthClientFeignClient.getOAuth2ClientById(clientId);
        if (R.ok().getCode().equals(result.getCode())) {
            OAuth2ClientDTO client = result.getData();
            BaseClientDetails clientDetails = new BaseClientDetails(
                    client.getClientId(),
                    client.getResourceIds(),
                    client.getScope(),
                    client.getAuthorizedGrantTypes(),
                    client.getAuthorities(),
                    client.getWebServerRedirectUri());
            clientDetails.setClientSecret(PasswordEncoderTypeEnum.NOOP.getPrefix() + client.getClientSecret());
            clientDetails.setAccessTokenValiditySeconds(client.getAccessTokenValidity());
            clientDetails.setRefreshTokenValiditySeconds(client.getRefreshTokenValidity());
            return clientDetails;
        } else {
            throw new NoSuchClientException(result.getMsg());
        }





    }
}
