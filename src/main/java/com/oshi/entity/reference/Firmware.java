package com.oshi.entity.reference;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Firmware {
    // 名称
    private String name;
    // 发布日期
    private String releaseDate;
    // 版本
    private String manufacturer;
}
