package org.springframework.boot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
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
