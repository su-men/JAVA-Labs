# spring-01-helloSpring
**演示spring通过xml装配bean，注入bean** 

1. 装配bean

    ```xml
    <bean id="hello" class="com.summer.pojo.Hello">
          <property name="str" value="spring"/>
    </bean>
    ```

2. 注入bean
    ```java
    ApplicationContext context = new 		ClassPathXmlApplicationContext("beans.xml");
    Hello hello = (Hello) context.getBean("hello");
    ```



# spring-02-ioc1

**本用例演示了实现ioc控制反转的两种方式：**

1. 通过上层用户接口传参的方式，将控制权交给上层用户

   ```java
      //service层选择不同的DaoImpl作为参数传入
      UserDao userDao = new UserDaoOracleImpl();
      //用户实际调用的Service层，而不会接触到Dao
      UserService userService = new UserServiceImpl();
      userService.setUserDao(userDao);
      userService.getUser()
   ```
2. 通过spring提供的set注入的方式
   ```xml
      <bean id="mysqlImpl" class="com.summer.dao.UserDaoMysqlImpl"/>
      <bean id="OracleImpl" class="com.summer.dao.UserDaoOracleImpl"/>
      <bean id="userServiceImpl" class="com.summer.service.UserServiceImpl">
         <property name="UserDao" ref="mysqlImpl"/>
      </bean>
   ```

   ```java
      ApplicationContext applicationContext = new 	   ClassPathXmlApplicationContext("beans.xml");
      UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("userServiceImpl");
      userService.getUser();
   ```
   



# Spring-03-ioc2

**该用例演示了bean装配的4种方式** 

1.  无参构造对象后，通过set注入对象属性

   ```xml
   <bean id="user" class="com.summer.pojo.User">
       <property name="name" value="无参创建的user"/>
   </bean>
   ```

2.  通过属性下标有参构造对象

   ```xml
   <bean id="user1" class="com.summer.pojo.User">
       <constructor-arg index="0" value="下标方式有参创建的user"/>
   </bean>
   ```

3. 通过属性名字方式构造对象

   ```xml
   <bean id="user2" class="com.summer.pojo.User">
       <constructor-arg name="name" value="属性名字方式有参创建的user"/>
   </bean>
   ```

4. 通过属性类型方式构造对象

   ```xml
   <bean id="user3" class="com.summer.pojo.User">
       <constructor-arg type="String" value="属性类型方式有参创建的user"/>
   </bean>
   ```

   

# spring-04-DI

**1.该用例演示了对象的复杂属性该如何注入**

**2.该用例演示了p标签、c标签的使用**

```xml
<!-- 引入p\c标签的规范-->
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
    https://www.springframework.org/schema/beans/spring-beans.xsd">
</beans>
```

```xml
    <!--p命名空间 对应 spring-beans中的 property属性 对应 类中的setter()方法 -->
    <bean id="user1" class="com.summer.pojo.User"
          p:id="adfafafa"
          p:name="root"
          p:password="misterkaoli"
    />
```

```xml
    <!--c命名空间 对应 spring-beans中的 constructor-arg属性 对应 类中的有参构造函数 -->
    <bean id="user2" class="com.summer.pojo.User"
          c:id="adfdfdfdf"
          c:name="root"
          c:password="dfdfdfdf"
    />
    <bean id="user3" class="com.summer.pojo.User" scope="prototype"
          c:user-ref="user1"
    />
```



# spring-06-anno
**该用例演示了一些常用的Spring注释**

* @Autowired 自动装配 firstByType,thenByName
  如果Autowired不能唯一自动装配上属性，则需要@Qualifier(value="xxx")
* @Resoure   自动装配 firstByName,thenByType
* @Nullable  标记在字段上，表示这个字段可以传为空
* @Component 标记在类上，表示这个类已经被Spring装配管理了,就是bean
* @Configuration 定义一个配置类，等价一个beans.xml

**使用Spring注解需要开启注解支持**

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">
    <!--指定要扫描的包，这个包下的注解会生效-->
    <context:component-scan base-package="com.summer.pojo"/>
    <context:annotation-config/>
</beans>
```



# spring-07-javaAppConfig

**该用例演示用javaConfig的方式替代xml做spring配置**

```java
/*
 *  @Configuration也会被注册到Spring中，因为它本身就是一个@Component,
 *  @Configuration代表这是一个配置类，和beans.xml一样
 */
@Configuration
@ComponentScan("com.summer.pojo")
public class UserConfig {
    //注册一个bean 等价于beans.xml里的<bean>标签
    //这个方法的名字，等价于id属性
    //这个方法的返回值，等价于class属性
    //<bean id="user1"  class="com.summer.pojo.User" scope="prototype">
    @Bean
    @Scope("prototype")
    public User user1(){
        return new User();
    }
    @Bean
    public User user2(){
        User user =  new User(); user.setName("dummer"); return  user;
    }
}
```

# spring-08-proxy

**该用例提供了两个demo演示了静态代理方法，和java提供的动态代理方法**



![image-20230201112016565](C:\Users\52903\AppData\Roaming\Typora\typora-user-images\image-20230201112016565.png)

第一个为静态代理方法，第二个为java jdk提供的自动生成动态代理类的方法

```java
/* 动态代理
 * 用这个类，自动生成代理类
 */
public class ProxyInvocationHandler implements InvocationHandler {
    //被代理的接口
    private Object target;
    public void setTarget(Object target){
        this.target = target;
    }
    //动态创建代理类
    public Object getProxy(){
       return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }
    //处理代理实例，并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //动态代理的本质，就是使用反射实现
        log(method.getName());
        Object result = method.invoke(target,args);
        return result;
    }
    public void log(String smg){
        System.out.println("[debug]" + smg + "被调用!");
    }
}
```

# spring-09-aop

**该用例提供了4种使用Spring aop的方式**

**首先需引用AOP约束**

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd">
</beans>
```

1.  使用原生Spring API接口

   ```xml
   <aop:config>
       <!--切入点-->
       <aop:pointcut id="pointcut" expression="execution(* com.summer.service.UserServiceImpl.*(..))"/>
       <!--执行环绕增加-->
       <aop:advisor advice-ref="log" pointcut-ref="pointcut"/>
       <aop:advisor advice-ref="afterLog" pointcut-ref="pointcut"/>
   </aop:config>
   ```

2. 自定义切面类

   ```xml
   <bean id = "diy" class="com.summer.diy.DiyPointCut"/>
   <aop:config>
       <!-- 自定义切面，ref 要引用的类 -->
       <aop:aspect ref="diy">
           <!-- 切入点 -->
           <aop:pointcut id="point" expression="execution(* com.summer.service.UserServiceImpl.*(..))"/>
           <!-- 通知 -->
           <aop:before method="before" pointcut-ref="point"/>
           <aop:after method="after" pointcut-ref="point"/>
       </aop:aspect>
   </aop:config>
   ```

3. 使用注解方式

   ```xml
   <bean id="anno" class="com.summer.diy.AnnotationPointCut"/>
   <!--开启注解支持-->
   <aop:aspectj-autoproxy/>
   ```

   ```java
   @Aspect
   public class AnnotationPointCut {
       @Before("execution(* com.summer.service.UserServiceImpl.*(..))")
       public void before(){
           System.out.println("===========annotation方法执行前========");
       }
       @After("execution(* com.summer.service.UserServiceImpl.*(..))")
       public void after(){
           System.out.println("===========annotation方法执行后========");
       }
       @Around("execution(* com.summer.service.UserServiceImpl.*(..))")
       public void around(ProceedingJoinPoint joinPoint) throws Throwable {
           System.out.println("环绕前");
           Object proceed = joinPoint.proceed();
           System.out.println("环绕后");
       }
   }
   ```

4. 结合javaConfig纯注解的方式

   ```java
   /*----------------------------------------------------------------*/
   @Configuration
   @EnableAspectJAutoProxy
   @ComponentScan("com.summer.service")
   public class AopConfig {
       //被代理的类，切入点
       @Bean
       public UserServiceImpl userService(){
           return new UserServiceImpl();
       }
       //注入Aop切面实现类
       @Bean
       public AnnoPointCut pointCut(){
           return new AnnoPointCut();
       }
   }
   /*----------------------------------------------------------------*/
   @Aspect //切面
   public class AnnoPointCut {
       ApplicationContext context = new  AnnotationConfigApplicationContext(LogConfig.class);
       AopLog log = context.getBean("aopLog", AopLog.class);
   
       @Before("execution(* com.summer.service.UserServiceImpl.*(..))")
       public void before(){
           log.beforeLog();
       }
       @After("execution(* com.summer.service.UserServiceImpl.*(..))")
       public void after(){
           log.afterLog();
       }
   }
   
   ```

   

# spring-10-mybaits

**该用例提供了三种整个mybatis的方式**

1. **xml配置的方式**

   * mybatis-config.xml  mybatis核心配置文件，配置所有内容，但不装配sqlSessionFactory,需要手动new

2. **xml配置的方式2**

   * mybatis-spring-dao.xml spring配置文件设置数据源，注入sqlSessionFactory，sqlSessionTemplate
   
   * mybatis-spring-config.xml mybatis核心配置文件，通用配置，例如设置别名
   * ApplicationContext.xml spring配置文件，两种方式装配mapper,一种注入sqlSession模板,一种使用sqlSessionFactory

     ```xml
     <bean id="userMapper" class="com.summer.mapper.UserMapperImpl">
         <property name="sqlSession" ref="sqlSessionTemplate"/>
     </bean>
     
     <bean id="userMapper2" class="com.summer.mapper.UserMapperImpl2">
         <property name="sqlSessionFactory" ref="sqlSessionFactory"/>
     </bean>
     ```

3. **JavaAppConfig与注解实现mybatis配置类**

   * MybatisDaoConfig: 设置数据源，bean注入sqlSessionFactory，sqlSessionTemplate，对应方法2中的mybatis-spring-dao.xml
   * ApplicationConfig: 注入mapper。对应方法2中的ApplicationContext.xml
   * mybatis-spring-config.xml mybatis核心配置文件，通用配置，例如设置别名,与方法2公用

# spring-11-transaction

**该用例提供了spring声明式事务的使用方法**

```xml
<!--结合AOP实现事务的注入-->
<!--配置事务的通知-->
<tx:advice id="txAdvice" transaction-manager="transactionManager">
<!--给方法配置事务-->
    <tx:attributes>
        <tx:method name="add" propagation="REQUIRED"/>
        <tx:method name="delete" propagation="REQUIRED"/>
        <tx:method name="update" propagation="REQUIRED"/>
        <tx:method name="query" read-only="true"/>
        <tx:method name="*" propagation="REQUIRED"/>
    </tx:attributes>
</tx:advice>

<aop:config>
    <aop:pointcut id="txPointcut" expression="execution(* summer.mapper.*.*(..))"/>
    <aop:advisor advice-ref="txAdvice" pointcut-ref="txPointcut"/>
</aop:config>
```

