package com.oshi.service.impl;

import com.oshi.service.ICPULoadService;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

@Service
public class CPULoadServiceImpl implements ICPULoadService {
    SystemInfo info = new SystemInfo();
    
    public double[] getCPULoad() {
        HardwareAbstractionLayer hardware = info.getHardware();
        CentralProcessor processor = hardware.getProcessor();
        // 统计1s内的使用率，所以阻塞1s 
        return processor.getProcessorCpuLoad(1000);
    }
}
