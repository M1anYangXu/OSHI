package com.oshi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oshi.entity.Hardware;
import com.oshi.entity.OperateSys;

public interface IHardwareService extends IService<Hardware> {
    
    Hardware getHardwareInfo();
}
