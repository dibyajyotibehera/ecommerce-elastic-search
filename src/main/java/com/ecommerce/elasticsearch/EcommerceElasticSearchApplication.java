package com.ecommerce.elasticsearch;

import com.ecommerce.elasticsearch.config.ESClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ESClient.class)
public class EcommerceElasticSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceElasticSearchApplication.class, args);
    }

}
