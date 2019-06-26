package cn.zcp.demo;

import cn.zcp.demo.mapper.CityMapper;
import cn.zcp.demo.model.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MybatisSpringbootApplicationTests {

    @Resource
    private CityMapper cityMapper;


    @Test
    public void contextLoads() {
    }

    @Test
    public void getCityTest(){

        City cityById = cityMapper.findCityById(1);
        System.out.println(cityById);
    }


}
