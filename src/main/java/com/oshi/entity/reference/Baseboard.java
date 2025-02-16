package com.oshi.entity.reference;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Baseboard {
    // 版本
    private String version;
    // 制造商
    private String manufacturer;
}
