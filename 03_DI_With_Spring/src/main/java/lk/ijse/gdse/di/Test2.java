package lk.ijse.gdse.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test2 implements Agreement {

//    @Autowired
//    DI test1 = new Test1();
//
//    public Test2() {
//        System.out.println("Test2 Constructor");
//    }
//
//    public void calledHelloMethod() {
//        System.out.println("Test2 Constructor");
//        test1.ssyHello();
//    }

//    DI test1;
//
//    public Test2(DI test1) {
//        this.test1 = test1;
//    }
//
//    public void calledHelloMethod() {
//        test1.ssyHello();
//    }

    // setter injection
//    DI test1;

//    @Autowired
//    public void setTest1(DI test1) {
//        this.test1 = test1;
//    }
//
//    public void calledHelloMethod() {
//        System.out.println("Test2 Constructor");
//        test1.ssyHello();
//    }
//
//    public Test2() {
//        System.out.println("Test2 Constructor");
//    }

    // interface injection

    DI test1;

    @Override
    public void setTest(DI test1) {
        this.test1 = test1;
    }

    public void calledHelloMethod() {
        test1.ssyHello();
    }
}
