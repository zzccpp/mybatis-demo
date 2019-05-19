package cn.zcp.demo;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhongchunping
 * @version 1.0
 * @Time 2019-05-19 10:01
 * @describe mybatis-demo <描述>
 *
 * 注意：如果已经有生成的文件存在，需要删除重新生成,如果设置生成的地址不存在,则不生成
 *
 *  官网地址：http://www.mybatis.org/generator/running/runningWithJava.html
 *  参考：https://www.jianshu.com/p/e09d2370b796
 *
 */
public class GeneratorSqlmap {

    public static void main(String[] args) throws Exception {

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("E:/IdeaProjects/mybatis-demo/mybatis-nxproject/src/main/resources/generatorConfig.xml");

        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

    }
}
