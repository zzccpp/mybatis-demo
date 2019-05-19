package cn.zcp.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 官网地址：http://www.mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/index.html
 *
 * @SpringBootApplication 会扫描当前启动类的所有子包,不扫描同级包
 *
 * 1、静态资源,放在resource/static/xxxx.x    访问的时候，localhost:8080/xxxx.x  跨过static目录
 * 2、连接数据库需要添加spring-boot-starter-jdbc包
 * 3、配置mapper位置及xml位置
 *
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}


