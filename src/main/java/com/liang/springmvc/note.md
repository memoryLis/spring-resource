1 @ConfigurationProperties(prefix = "server", ignoreUnknownFields = true) 用于从配置文件中注入属性
2 @Import注解作用
1. 结合 ImportSelector接口，如果指定的类实现了ImportSelector接口并且实现了其中方法，那么会调用该方法，返回一个String数组，里面包含了
类的全限定名称，会把这些类注入容器中
2. 如果指定的是普通类，没有实现ImportSelector接口，直接把这个普通类注入容器中
3. @PostConstruct 的确切执行时机
   在 Bean 的构造方法执行完毕之后
   在属性赋值完成之后
   在 InitializingBean 的 afterPropertiesSet() 方法之前
   在自定义的 init() 方法之前