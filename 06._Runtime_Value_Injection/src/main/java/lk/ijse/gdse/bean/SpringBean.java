package lk.ijse.gdse.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBean implements InitializingBean {

    @Value("hasindu")
    private String name;

    public SpringBean() {
        System.out.println(name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(name);
    }


//    public SpringBean() {}

    /*@Autowired(required = false)
    public SpringBean(@Value("hasindu") String name, @Value("23") int number, @Value("true") boolean isActive) {
        System.out.println("SpringBean constructor : " + name);
        System.out.println("SpringBean constructor : " + number);
        System.out.println("SpringBean constructor : " + isActive);
    }

    @Autowired(required = false)
    public SpringBean(@Value("hasindu") String name, @Value("23") int number) {
        System.out.println("SpringBean constructor : " + name);
        System.out.println("SpringBean constructor : " + number);
    }*/

}