package lk.ijse.gdse.config;

import lk.ijse.gdse.bean.A;
import lk.ijse.gdse.bean.B;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig1 {

    @Bean
    public A a() {
        return new A();
    }

    @Bean
    public B b() {
        return new B();
    }
}
