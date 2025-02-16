package com.oshi.utils;

import java.net.InetAddress;


public class GetIPAddress {
    // 获取IP
    public static String getIPAddress() throws Exception{
        InetAddress localhost = InetAddress.getLocalHost();
        return localhost.getHostAddress();
    }
}

