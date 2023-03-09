package com.zut.auth.common.enums;
import lombok.Getter;
/**
 * @Date 2023-03-08 20:44 星期三
 * @Author: 聂建强
 * @Description:  SpringSecurity的加密类型枚举
 */
public enum PasswordEncoderTypeEnum {

    BCRYPT("{bcrypt}","BCRYPT加密"),
    NOOP("{noop}","无加密明文");

    @Getter
    private String prefix;

    PasswordEncoderTypeEnum(String prefix, String desc){
        this.prefix=prefix;
    }

}
