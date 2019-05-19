package cn.zcp.demo.controller;

import cn.zcp.demo.mapper.CityMapper;
import cn.zcp.demo.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author zhongchunping
 * @version 1.0
 * @Time 2019-05-19 17:20
 * @describe mybatis-demo <描述>
 */
@Controller
public class CityController {
    private static Logger logger =  Logger.getLogger(CityController.class.getName());

    /*@Resource
    private CityMapper cityMapper;*/

    @Autowired
    private CityMapper cityMapper;

    @RequestMapping("/getCity")
    @ResponseBody
    public Object findByState(String state){

        List<City> citys = cityMapper.findByState(state);
        return citys;
    }

    @RequestMapping("/findCityById")
    @ResponseBody
    public Object findCityById(Integer id){
        logger.info("查询ID为："+id);
        City city = cityMapper.findCityById(id);
        return city;
    }


}
