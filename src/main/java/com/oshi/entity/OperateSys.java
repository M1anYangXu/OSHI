package com.oshi.entity;

import lombok.Data;

@Data
public class OperateSys {
    private String family;
    private Integer bitness;
    private String version;
    private Long uptime;
    private String manufacturer;
}
