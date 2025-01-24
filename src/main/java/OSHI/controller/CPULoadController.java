package OSHI.controller;

import OSHI.common.Result;
import OSHI.service.CPULoadService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cpu")
public class CPULoadController {
    
    @Resource
    CPULoadService cpuLoadService;
    
    @GetMapping("/load")
    public Result getCPULoad() {
        double[] cpuLoad = cpuLoadService.getCPULoad();
        return Result.success(cpuLoad);
    }
    
}
