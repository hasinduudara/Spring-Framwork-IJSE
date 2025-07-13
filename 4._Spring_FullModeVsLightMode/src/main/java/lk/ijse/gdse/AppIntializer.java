package lk.ijse.gdse;

import lk.ijse.gdse.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppIntializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        context.registerShutdownHook();
    }
}
