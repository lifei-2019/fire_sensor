package com.l;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.l")
@EnableAutoConfiguration
@Configuration
@EnableAsync
@EnableScheduling
@MapperScan("com.l")
@EnableSwagger2
public class SensorApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SensorApplication.class, args);
    }

    /**
     * Application类中被重写的configure方法就是使用嵌入式的Spring上下文注册应用的地方。
     * 在更为正式的场景之中，这个方法可能会用来注册Spring Java配置类，它会定义应用中所有
     * controller和服务的bean。
     *
     * @param application
     * @see <a href="http://www.infoq.com/cn/articles/microframeworks1-spring-boot">info</a>
     */
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SensorApplication.class);
    }

}