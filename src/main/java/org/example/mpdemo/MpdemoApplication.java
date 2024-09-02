package org.example.mpdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 与数据库相关的操作都在mapper包下，需要告诉它mapper包的位置，然后才能启动
@MapperScan("org.example.mpdemo.demos.mapper")  // 这样mapper里的文件才能在启动时生效
public class MpdemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MpdemoApplication.class, args);
    }

}
