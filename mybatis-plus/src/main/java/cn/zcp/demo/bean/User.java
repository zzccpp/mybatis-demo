package cn.zcp.demo.bean;

import lombok.Data;
/**
 * @author zhongchunping
 * @version 1.0
 * @Time 2019-06-26 16:33
 * @describe mybatis-demo <描述>
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}