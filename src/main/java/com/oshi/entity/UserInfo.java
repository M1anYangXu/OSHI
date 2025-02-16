package com.oshi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@TableName("userinfo")
public class UserInfo implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    Integer id;
//    @MppMultiId
    @TableField("ip_address")
    String ipAddress;
//    @MppMultiId
    @TableField("username")
    String username;
    @TableField("host")
    String host;
    @TableField("terminal_device")
    String terminalDevice;
    @TableField("serial_number")
    String serialNumber;
    @TableField("login_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    Timestamp loginTime;
}
