package com.zut.common.base.constant;

/**
 * @Date 2023-03-08 20:09 星期三
 * @Author: 聂建强
 * @Description:  SpringSecurity相关的常量
 */
public interface SecurityConstants {

    /**
     * 认证请求头key
     */
    String AUTHORIZATION_KEY = "Authorization";

    /**
     * JWT令牌前缀
     */
    String JWT_PREFIX = "Bearer ";


    /**
     * Basic认证前缀
     */
    String BASIC_PREFIX = "Basic ";

    /**
     * JWT载体key
     */
    String JWT_PAYLOAD_KEY = "payload";


    /**
     * JWT存储权限前缀
     */
    String AUTHORITY_PREFIX = "ROLE_";

    /**
     * JWT存储权限属性
     */
    String JWT_AUTHORITIES_KEY = "authorities";

    /**
     * 客户端ID的Key
     */
    String CLIENT_ID_KEY = "client_id";
}
