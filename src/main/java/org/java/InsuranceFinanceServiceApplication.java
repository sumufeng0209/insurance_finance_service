package org.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class InsuranceFinanceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsuranceFinanceServiceApplication.class, args);
    }

}
