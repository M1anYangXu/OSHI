package oshi;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import oshi.hardware.*;
import oshi.software.os.OSSession;
import oshi.software.os.OperatingSystem;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class OSHISystemTest {
    SystemInfo si = new SystemInfo();
    // 操作系统信息 软件信息
    OperatingSystem os = si.getOperatingSystem();
    // 硬件信息
    HardwareAbstractionLayer hal = si.getHardware();
    
// 操作系统相关
    @Test
    void test() {
        System.out.println("操作系统位数-" + os.getBitness());
        System.out.println("操作系统名称-" + os.getFamily());
        System.out.println("操作系统版本-" + os.getFamily()+os.getVersionInfo().getVersion());
        System.out.println("操作系统启动时间-" + os.getSystemUptime() / 3600 + "小时," + (os.getSystemUptime() % 3600) / 60 + "分钟");
        System.out.println("获取操作系统的制造商-" + os.getManufacturer());
//        System.out.println("获取当前正在运行的进程数-"+os.getProcessCount());
//        System.out.println("获取系统上的所有服务数-"+os.getServices().size());
    }
    
    // 获取计算机硬件信息
    @Test
    void test2() {
        // 计算机系统硬件
//        ComputerSystem cs = hal.getComputerSystem();
//        System.out.println("获取计算机硬件信息-系统模型" + cs.getModel());
//        System.out.println("获取计算机硬件信息-制造商" + cs.getManufacturer());
//        System.out.println("获取计算机硬件信息-序列号" + cs.getSerialNumber());
//        System.out.println("获取计算机硬件信息-硬件uuid" + cs.getHardwareUUID());
//        System.out.println("获取计算机硬件信息-系统固件-名称" + cs.getFirmware().getName());
//        System.out.println("获取计算机硬件信息-系统固件-发布时期" + cs.getFirmware().getReleaseDate());
//        System.out.println("获取计算机硬件信息-系统固件-制造商" + cs.getFirmware().getManufacturer());
//        System.out.println("获取计算机硬件信息-系统主板-版本" + cs.getBaseboard().getVersion());
//        System.out.println("获取计算机硬件信息-系统主板-制造商" + cs.getBaseboard().getManufacturer());
//        // 电池
//        System.out.println("=================电池===============");
//        List<PowerSource> powerSources = hal.getPowerSources();
//        System.out.println("获取计算机硬件信息-电池-操作系统级别的名称" + powerSources.get(0).getName());
//        System.out.println("获取计算机硬件信息-电池-设置级别的名称" + powerSources.get(0).getDeviceName());
//        System.out.println("获取计算机硬件信息-电池-目前电量" + powerSources.get(0).getCurrentCapacity());
//        System.out.println("获取计算机硬件信息-电池-设计原始容量" + powerSources.get(0).getDesignCapacity());
//        System.out.println("获取计算机硬件信息-电池-是否在放电" + powerSources.get(0).isDischarging());
//        // 声卡
//        System.out.println("=================声卡===============");
//        System.out.println("获取计算机硬件信息-声卡-名称" + hal.getSoundCards().get(0).getName());
//        System.out.println("获取计算机硬件信息-声卡-版本" + hal.getSoundCards().get(0).getDriverVersion());
//        // 网卡
//        System.out.println("=================网卡===============");
//        for (NetworkIF networkIF : hal.getNetworkIFs()) {
//            // 过滤条件：网卡有 IP 地址、不是回环接口、MAC 地址不为全零
//            if (networkIF.getIPv4addr().length != 0 && // 有 IP 地址
//                    !networkIF.getName().startsWith("lo") && // 不是回环接口
//                    !networkIF.getMacaddr().equals("00:00:00:00:00:00")) { // MAC 地址不为全零
//            System.out.println("获取计算机硬件信息-网卡-名称" + networkIF.getName());
//            System.out.println("获取计算机硬件信息-网卡-IP4地址" + Arrays.toString(networkIF.getIPv4addr()));
//            System.out.println("获取计算机硬件信息-网卡-MAC地址" + hal.getNetworkIFs().get(0).getMacaddr());
//            }
//        }
       
        // 显卡
//        System.out.println("=================显卡===============");
//        for (GraphicsCard graphicsCard : hal.getGraphicsCards()) {
//            System.out.println("获取计算机硬件信息-显卡-名称" + graphicsCard.getName());
//            System.out.println("获取计算机硬件信息-显卡-制造商" + graphicsCard.getVendor());
//            System.out.println("获取计算机硬件信息-显卡-版本" + graphicsCard.getVersionInfo());
//        }
        
        // CPU信息
//        System.out.println("=================CPU===============");
//        CentralProcessor processor = hal.getProcessor();
//        System.out.println("获取CPU信息-CPU名称" + processor.getProcessorIdentifier().getName());
//        System.out.println("获取CPU信息-CPU厂商" + processor.getProcessorIdentifier().getVendor());
//        System.out.println("获取CPU信息-逻辑核心数" + processor.getLogicalProcessorCount());
//        System.out.println("获取CPU信息-物理核心数" + processor.getPhysicalProcessorCount());
    }

    // 获取当前进程信息
    @Test
    void PersonProcessorInfo() {
        // 进程使用者，进程开始时间，进程状态，进程ip，进程路径，进程名称，进程位数，进程的当前命令行，进程的环境变量，进程的工作目录
        System.out.println("获取当前进程 名称"+os.getCurrentProcess().getName());
        System.out.println("获取当前进程 路径"+os.getCurrentProcess().getPath());
        System.out.println("获取当前进程 ID"+os.getCurrentProcess().getProcessID());
        System.out.println("获取当前进程 状态"+os.getCurrentProcess().getState());
        System.out.println("获取当前进程 用户"+os.getCurrentProcess().getUser());
        System.out.println("获取当前进程 累积CPU使用率"+os.getCurrentProcess().getProcessCpuLoadCumulative());
        System.out.println("获取当前进程 位数"+os.getCurrentProcess().getBitness());
        System.out.println("获取当前进程 当前工作目录"+os.getCurrentProcess().getCurrentWorkingDirectory());
    }

    // 根据pid获取当前进程信息
    @Test
    void OtherProcessInfo() {
        int pid = 23576;
        System.out.println("根据pid获取当前进程信息"+os.getProcess(pid));
    }
    
    // 获取当前线程的信息
    @Test
    void getThreadInfo() {
        System.out.println("获取当前线程 ID"+os.getCurrentThread().getThreadId());
        System.out.println("获取当前线程 名称"+os.getCurrentThread().getName());
        System.out.println("获取当前线程 状态"+os.getCurrentThread().getState());
        System.out.println("获取当前线程 已运行时间"+os.getCurrentThread().getUpTime());
        System.out.println("获取当前线程 拥有的线程ID"+os.getCurrentThread().getOwningProcessId());
    }
    
    // 获取所有服务信息
    @Test
    void getAllService() {
        System.out.println("获取所有服务"+os.getServices());
    }
    
    // 获取所有进程 根据CPU占用降序排序
    @Test
    void getAllProcess() {
//        ALL_PROCESSES 所有进程  BITNESS_32 32位  BITNESS_64 64位   NO_PARENT 排除子进程  VALID_PROCESS 排除不合法进程
        // CPU_DESC NAME_ASC
        String filterType;
        String sortType;
        System.out.println("获取所有进程"+os.getProcesses(OperatingSystem.ProcessFiltering.ALL_PROCESSES, OperatingSystem.ProcessSorting.NO_SORTING, 50));
    }
    
    // 获取用户信息
    @Test
    void getUserInfo() throws UnknownHostException {
        List<OSSession> sessions = os.getSessions();
        sessions.sort(Comparator.comparing(OSSession::getLoginTime).reversed());
        InetAddress localhost = InetAddress.getLocalHost();
        String hostIPAddress = localhost.getHostAddress();
        System.out.println("主机IP地址: " + hostIPAddress);

        System.out.println("获取当前登录的用户: "+sessions.get(0).getUserName()+
                "登录时间: "+ new Timestamp(sessions.get(0).getLoginTime())
                +"登录主机: "+sessions.get(0).getHost()
                +"获取用户用于登录的终端设备: "+sessions.get(0).getTerminalDevice());
    }
  
}
    
 
