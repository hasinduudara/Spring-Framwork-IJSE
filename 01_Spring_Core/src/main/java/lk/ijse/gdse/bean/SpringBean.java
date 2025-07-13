package lk.ijse.gdse.bean;

import org.springframework.stereotype.Component;

@Component
public class SpringBean {
    public SpringBean() {
        System.out.println("SpringBean instance created");
    }

    public void testBean() {
        System.out.println("Testing SpringBean");
    }
}
