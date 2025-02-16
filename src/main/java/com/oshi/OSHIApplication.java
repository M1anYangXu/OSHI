package com.oshi;

import com.github.jeffreyning.mybatisplus.conf.EnableMPP;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 开启mybatis-plus-plus 联合主键
@MapperScan("com.oshi.mapper")
@EnableMPP
public class OSHIApplication {
    public static void main(String[] args) {
        SpringApplication.run(OSHIApplication.class, args);
    }

}
