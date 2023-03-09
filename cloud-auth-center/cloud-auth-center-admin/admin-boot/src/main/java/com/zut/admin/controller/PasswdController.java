package com.zut.admin.controller;

import com.zut.common.base.result.R;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2023-03-09 11:16 星期四
 * @Author: 聂建强
 * @Description:
 */

@RestController
@RequestMapping("/passwd")
@RequiredArgsConstructor
public class PasswdController {

    private final PasswordEncoder passwordEncoder;
    @RequestMapping("/genPasswd/{passwd}")
    public R<String> genPasswd(@PathVariable("passwd") String passwd){
        return R.ok(passwordEncoder.encode(passwd));
    }
}
