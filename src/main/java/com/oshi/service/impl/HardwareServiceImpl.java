package com.oshi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oshi.entity.Hardware;
import com.oshi.entity.OperateSys;
import com.oshi.entity.reference.Baseboard;
import com.oshi.entity.reference.Firmware;
import com.oshi.mapper.HardwareMapper;
import com.oshi.mapper.OperateSysMapper;
import com.oshi.service.IHardwareService;
import com.oshi.service.IOperateSysService;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.ComputerSystem;
import oshi.hardware.HardwareAbstractionLayer;

@Service
public class HardwareServiceImpl extends ServiceImpl<HardwareMapper, Hardware> implements IHardwareService {

    SystemInfo si = new SystemInfo();
    // 操作系统信息 软件信息
    HardwareAbstractionLayer hal = si.getHardware();
    
    ComputerSystem cs = hal.getComputerSystem();
    
    @Override
    public Hardware getHardwareInfo() {
        Hardware hardware = new Hardware();
        hardware.setBaseboard(new Baseboard(cs.getBaseboard().getVersion(), cs.getBaseboard().getManufacturer()));
        hardware.setFirmware(new Firmware(cs.getFirmware().getName(), cs.getFirmware().getManufacturer(), cs.getFirmware().getReleaseDate()));
        hardware.setModel(cs.getModel());
        hardware.setManufacturer(cs.getManufacturer());
        hardware.setSerialNumber(cs.getSerialNumber());
        hardware.setHardwareUUID(cs.getHardwareUUID());
        return hardware;
    }
}

