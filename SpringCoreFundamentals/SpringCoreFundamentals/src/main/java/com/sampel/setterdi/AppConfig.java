package com.sampel.setterdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Address address(){
    return new Address();
    }

    @Bean
    public Employee emp(Address address){
        Employee emp1=new Employee();
             emp1.setAddress(address);
        return emp1;

    }
}
