package com.oshi.controller;

import com.oshi.common.Result;
import com.oshi.entity.Hardware;
import com.oshi.entity.OperateSys;
import com.oshi.service.IHardwareService;
import com.oshi.service.IOperateSysService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "计算机硬件信息")
@RestController
@RequestMapping("/hardware")
public class HardwareController {
    
    @Resource
    IHardwareService hardwareService;
    
    @Operation(summary = "获取操作系统的信息")
    @GetMapping("/info")
    public Result<Hardware> getOperatingSystemInfo() {
        Hardware hardware = hardwareService.getHardwareInfo();
        return Result.success(hardware);
    }
}
