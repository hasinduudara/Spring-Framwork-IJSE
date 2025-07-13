package lk.ijse.gdse.config;

import lk.ijse.gdse.bean.MyConnection;
import lk.ijse.gdse.bean.TestBean1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "lk.ijse.gdse.bean")
@ComponentScan(basePackageClasses =  TestBean1.class)
public class AppConfig {
    @Bean("udara")
    MyConnection getConnection() {
        return new MyConnection();
    }
}
