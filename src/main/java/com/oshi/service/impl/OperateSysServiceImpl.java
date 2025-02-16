package com.oshi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oshi.entity.OperateSys;
import com.oshi.mapper.OperateSysMapper;
import com.oshi.service.IOperateSysService;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

@Service
public class OperateSysServiceImpl extends ServiceImpl<OperateSysMapper, OperateSys> implements IOperateSysService {

    SystemInfo si = new SystemInfo();
    // 操作系统信息 软件信息
    OperatingSystem os = si.getOperatingSystem();
    
    @Override
    public OperateSys getOperatingSystemInfo() {
        OperateSys operateSys = new OperateSys();
        operateSys.setBitness(os.getBitness());
        operateSys.setFamily(os.getFamily());
        operateSys.setManufacturer(os.getManufacturer());
        operateSys.setUptime(os.getSystemUptime());
        operateSys.setVersion(os.getFamily()+" "+os.getVersionInfo().getVersion());
        return operateSys;
    }
}

