package com.oshi.controller;

import com.oshi.common.Result;
import com.oshi.service.IUserInfoService;
import com.oshi.entity.UserInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "用户信息")
@RestController
@RequestMapping ("/user")
public class UserInfoController {
  
    @Resource
    IUserInfoService userInfoService;
    
    @Operation(summary = "获取登录主机的用户信息")
    @GetMapping("/info")
    public Result<UserInfo> getUserInfo() throws Exception {
        UserInfo userInfo = userInfoService.getUserInfo();
        return Result.success(userInfo);
    }
}
