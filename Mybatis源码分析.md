###mybatis的源码分析
***
* 先分析mybatis包中的各个模块.


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

