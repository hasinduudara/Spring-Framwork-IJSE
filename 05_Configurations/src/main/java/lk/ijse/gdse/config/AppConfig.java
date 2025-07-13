package lk.ijse.gdse.config;

import lk.ijse.gdse.bean.SpringBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({AppConfig1.class, AppConfig2.class})

// mehema danne file eka root path eke thiyenam witharai
//@ImportResource("classpath:hibernate.cfg.xml")

// mehema danne root path eke naththam
//@ImportResource("file:absolute-path-of-hibernate.cfg.xml")
public class AppConfig {

    @Bean
    public SpringBean springBean() {
        return new SpringBean();
    }
}
