package com.oshi.service;

import com.baomidou.mybatisplus.extension.service.IService;

public interface ICPULoadService {
    double[] getCPULoad();
}
