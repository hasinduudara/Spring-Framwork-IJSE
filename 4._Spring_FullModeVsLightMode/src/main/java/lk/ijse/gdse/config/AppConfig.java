package lk.ijse.gdse.config;

import lk.ijse.gdse.bean.SpringBeanOne;
import lk.ijse.gdse.bean.SpringBeanTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "lk.ijse.gdse.bean")
public class AppConfig {

    // Full Mode
    @Bean
    public SpringBeanOne springBeanOne() {
        // InterBean Dependencies
        SpringBeanTwo springBeanTwo1 = springBeanTwo();
        SpringBeanTwo springBeanTwo2 = springBeanTwo();

        System.out.println(springBeanTwo1);
        System.out.println(springBeanTwo2);
        return new SpringBeanOne();
    }

    @Bean
    public SpringBeanTwo springBeanTwo () {
        return new SpringBeanTwo();
    }
}
