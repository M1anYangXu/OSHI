package com.oshi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oshi.entity.OperateSys;

public interface IOperateSysService extends IService<OperateSys> {
    OperateSys getOperatingSystemInfo();
}
