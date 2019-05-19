package cn.zcp.demo;

import cn.zcp.demo.mapper.CityMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 官网地址：http://www.mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/index.html
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MybatisSpringbootApplication implements CommandLineRunner {

    private final CityMapper cityMapper;

    public MybatisSpringbootApplication(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(MybatisSpringbootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.cityMapper.findByState("CA"));
    }
}
