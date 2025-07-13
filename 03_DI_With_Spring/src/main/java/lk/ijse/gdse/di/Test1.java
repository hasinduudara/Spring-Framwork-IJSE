package lk.ijse.gdse.di;

import org.springframework.stereotype.Component;

@Component
public class Test1 implements DI {
    public Test1() {
        System.out.println("Test1 Constructor");
    }

    public void ssyHello() {
        System.out.println("Test1 Say Hello");
    }
}
