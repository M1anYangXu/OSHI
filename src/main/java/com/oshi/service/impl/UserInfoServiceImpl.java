package com.oshi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.oshi.common.Result;
import com.oshi.entity.UserInfo;
import com.oshi.mapper.UserInfoMapper;
import com.oshi.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oshi.utils.GetIPAddress;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSSession;
import oshi.software.os.OperatingSystem;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;


@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {
    oshi.SystemInfo si = new SystemInfo();
    // 操作系统信息
    OperatingSystem os = si.getOperatingSystem();
    // 硬件信息
    HardwareAbstractionLayer hal = si.getHardware();

    @Override
    public UserInfo getUserInfo() throws Exception {
        // 获取IP地址
        String hostIPAddress = GetIPAddress.getIPAddress();
        // 获取最近登录的用户
        List<OSSession> sessions = os.getSessions();
        sessions.sort(Comparator.comparing(OSSession::getLoginTime).reversed());
        // 如果当前序列号和登录用户名和登录主机名相同 不保存
        LambdaQueryWrapper<UserInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserInfo::getHost, sessions.get(0).getHost())
                .eq(UserInfo::getSerialNumber, hal.getComputerSystem().getSerialNumber())
                .eq(UserInfo::getUsername, sessions.get(0).getUserName());
        // 如果记录为0 则插入
        if (this.count(wrapper) == 0) {
            UserInfo userInfo = new UserInfo();
            userInfo.setIpAddress(hostIPAddress);
            userInfo.setUsername(sessions.get(0).getUserName());
            userInfo.setHost(sessions.get(0).getHost());
            userInfo.setTerminalDevice(sessions.get(0).getTerminalDevice());
            userInfo.setLoginTime(new Timestamp(sessions.get(0).getLoginTime()));
            userInfo.setSerialNumber(hal.getComputerSystem().getSerialNumber());
            this.save(userInfo);
            return userInfo;
        }
        // 否则 更新其他参数
        // 这里因为使用了联合主键 updateById 找不到@TableId 所以需要使用update方法
        LambdaUpdateWrapper<UserInfo> uWrapper = new LambdaUpdateWrapper<>();
        uWrapper.eq(UserInfo::getHost, sessions.get(0).getHost())
                .eq(UserInfo::getSerialNumber, hal.getComputerSystem().getSerialNumber())
                .eq(UserInfo::getUsername, sessions.get(0).getUserName());
        UserInfo userInfo = this.getOne(wrapper);
        // 更新这三个字段
        userInfo.setTerminalDevice(sessions.get(0).getTerminalDevice());
        userInfo.setLoginTime(new Timestamp(sessions.get(0).getLoginTime()));
        userInfo.setIpAddress(hostIPAddress);
        // 这里时间不一定会变 是因为 不是当前时间 而是开机时间
        this.update(userInfo,uWrapper);
        return userInfo;
        
    }
}
