package org.java;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableEurekaClient
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableRedisHttpSession
public class InsuranceFinanceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsuranceFinanceServiceApplication.class, args);
    }

}
