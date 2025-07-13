package lk.ijse.gdse.bean;

import org.springframework.stereotype.Component;

@Component
public class Girl implements Agreement{
    public Girl() {
        System.out.println("Girl Constructor");
    }


    @Override
    public void chat() {
        System.out.println("chatting...");
    }
}
