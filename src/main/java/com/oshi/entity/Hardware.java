package com.oshi.entity;

import com.oshi.entity.reference.Baseboard;
import com.oshi.entity.reference.Firmware;
import lombok.Data;

@Data
public class Hardware {
    private String model;
    private String manufacturer;
    private String serialNumber;
    private String hardwareUUID;
    
    // 系统固件 BIOS
    private Firmware firmware;
    // 系统主板 
    private Baseboard baseboard;
}
