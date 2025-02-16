package com.oshi.controller;

import com.oshi.common.Result;
import com.oshi.service.ICPULoadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "CPU")
@RestController
@RequestMapping("/cpu")
public class CPULoadController {
    
    @Resource
    ICPULoadService cpuLoadService;

    @Operation(summary = "CPU利用率")
    @GetMapping("/load")
    public Result<Object> getCPULoad() {
        double[] cpuLoad = cpuLoadService.getCPULoad();
        return Result.success(cpuLoad);
    }
    
}
