package com.github.williamjbf.dacdeliveryapi;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DacDeliveryApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DacDeliveryApiApplication.class, args);
    }

    @Bean
    public JtsModule jtsModule(){
        return new JtsModule();
    }
}
