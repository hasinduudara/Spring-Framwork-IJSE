package lk.ijse.gdse.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Girl1 implements Agreement{
    public Girl1() {
        System.out.println("Girl1 Constructor");
    }


    @Override
    public void chat() {
        System.out.println("chatting girl 1...");
    }
}
