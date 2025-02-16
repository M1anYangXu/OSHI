package com.oshi.controller;

import com.oshi.common.Result;
import com.oshi.entity.OperateSys;
import com.oshi.service.IOperateSysService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "操作系统")
@RestController
@RequestMapping("/operate")
public class OperateSysController {
    
    @Resource
    IOperateSysService operatingSystemService;
    
    @Operation(summary = "获取操作系统的信息")
    @GetMapping("/info")
    public Result<OperateSys> getOperatingSystemInfo() {
        OperateSys systemInfo = operatingSystemService.getOperatingSystemInfo();
        return Result.success(systemInfo);
    }
    
}
