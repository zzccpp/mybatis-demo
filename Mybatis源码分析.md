###mybatis的源码分析
***
* 先分析mybatis包中的各个模块.

通过SqlSessionFactoryBuilder的build的方法，
>XMLConfigBuilder把config.xml文件解析转换为一个Configuration对象
    重要解析:mapper标签，如果是指定的xml时，直接解析构建statement对象，存入mappedStatements MAP结合中
    如果是执行的package，则扫描这个包下的所有接口，添加至kownMapper MAP集合中，并且会尝试扫描当前class目录下的通类名称.xml文件，如果存在则添加至存入mappedStatements MAP结合中
>通过new DefaultSqlSessionFactory(config)来创建一个SqlSessionFactory对象、


sessionFactory.openSession()
>1、通过工厂得到sqlSession对象(其中有创建一个executor,如果有设置启用二级缓存（默认启用）则使用CachingExecutor包装，)
>2、查看是否有使用插件，如果有的话，循环插件对Executor生成代理对象,为了调用plug中intercept方法

sqlSession.getMapper(UserMapper.class);
>1、创建Mapper代理对象

userMapper.findUserById(1);
>1、执行代理对象方法
>org.apache.ibatis.binding.MapperProxy#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
>判断如果是object的方法是，执行执行，如果是Mapper接口中定义的方法时，
>org.apache.ibatis.binding.MapperMethod.SqlCommand#resolveMappedStatement()
>则使用mapperInterface.getName() + "." + methodName; 去Configuration中mappedStatements中去查找相应的SQL


1、mapper是通过动态代理（默认jdk），可以在mapperFactoryproxy类中配置(配置文件setting)
mapper保存在map中，key为statmentId...

问题1：methodproxy 53行啥时候执行？
问题2：为啥要定义一个mapper接口，而非实体类
    1、动态代理需要接口，
问题3：lazy-loading是怎么做到的？


从0-1学习
    首先看官网文档，去网站找参考资料（有基本的概念，产生很多问题，很多猜想）
    然后，看项目结构（更加具体的了解，还有产生很多猜想）
    
    为什么会存在spring这个东西，能做深，做了什么，要我来做，该怎么做？

