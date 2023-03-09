package com.zut.admin.api;

import com.zut.admin.dto.UserAuthDTO;
import com.zut.common.base.result.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Date 2023-03-09 10:39 星期四
 * @Author: 聂建强
 * @Description:
 */

@FeignClient(value = "cloud-auth-center-admin")
public interface UserFeignClient {

    @GetMapping("/api/v1/users/username/{username}")
    R<UserAuthDTO> getUserByUsername(@PathVariable String username);

    @GetMapping("/api/v1/users/member/username/{username}")
    R<UserAuthDTO> getMemberUserByUsername(@PathVariable String username);

}
