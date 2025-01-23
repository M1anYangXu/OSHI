package oshi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;

import java.util.Arrays;
import java.util.List;

public class OSHITest {
    // 创建si对象
    SystemInfo systemInfo = new SystemInfo();
    
    
    @Test
    void testCPU(){
        HardwareAbstractionLayer hardware = systemInfo.getHardware();

        // 拿到cpu信息
        CentralProcessor processor = hardware.getProcessor();
        // 获取cpu最大频率
        long maxFreq = processor.getMaxFreq();
        // 最大频率
        System.out.println("最大频率"+maxFreq);
        // 获取cpu当前频率 逻辑cpu
        long[] currentFreq = processor.getCurrentFreq();
        System.out.println("当前频率"+ Arrays.toString(currentFreq));
        // 当前频率/最大频率 = 当前cpu使用率
        
        // 获取cpu 1s 的使用情况 
        double[] processorCpuLoad = processor.getProcessorCpuLoad(1000);
        System.out.println("1s内cpu使用率"+Arrays.toString(processorCpuLoad));
    }
    
    
    @SneakyThrows
    @Test
    void testMemory() {
        HardwareAbstractionLayer hardware = systemInfo.getHardware();
        // 获取内存信息
        GlobalMemory memory = hardware.getMemory();
        System.out.println("可用内存"+memory.getAvailable());
        System.out.println(JSON.toJSONString(memory, SerializerFeature.PrettyFormat));
    }
    
    
    // 获取进程信息
    @SneakyThrows
    @Test
    void contextLoads() throws JsonProcessingException {
        // 获取操作系统对象
        OperatingSystem operatingSystem = systemInfo.getOperatingSystem();

        ObjectMapper objectMapper = new ObjectMapper();
        List<OSProcess> processes = operatingSystem.getProcesses();

        System.out.println("进程总数"+operatingSystem.getProcessCount());
        
        for (OSProcess process : processes) {
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(process);
            System.out.println(json);
        }
    }
}
