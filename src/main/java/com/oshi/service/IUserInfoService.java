package com.oshi.service;

import com.oshi.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IUserInfoService extends IService<UserInfo> {
    UserInfo getUserInfo() throws Exception;
}
