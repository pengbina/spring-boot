package org.springframework.boot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 * @SpringBootApplication注解中包含了自动配置的入口注解：@EnableAutoConfiguration
 *
 * Servlet容器自动配置原理：
 * EmbeddedServletContainerAutoConfiguration
 * 其中EmbeddedServletContainerAutoConfiguration是嵌入式Servlet容器的自动配置类，该类在spring-boot-autoconfigure.jar中的web模块可以找到。
 */
@SpringBootApplication
public class SpringBootDemoApplication
{
    public static void main( String[] args )
    {

		SpringApplication.run(SpringBootDemoApplication.class,args);

		System.out.println(System.currentTimeMillis());
    }
}
