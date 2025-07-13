package lk.ijse.gdse;

import lk.ijse.gdse.bean.*;
import lk.ijse.gdse.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        SpringBean bean1 = context.getBean(SpringBean.class);
        bean1.testBean();
        System.out.println(bean1);

//        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            System.out.println("JVM is shutting down...");
//            context.close();
//        }));

        // uda eka wenuwata pahala ekath use karanna puluwan

        context.registerShutdownHook();

        // Get beans from the class
//        TestBean1 testBean1 = context.getBean(TestBean1.class);
//        System.out.println(testBean1);

        // Get bean from by ID
//        TestBean2 byBeanID = (TestBean2) context.getBean("hasindu");
//        System.out.println(byBeanID);

        // Get bean from by ID and Class
//        TestBean3 testBean3 = context.getBean("testBean3", TestBean3.class);
//        System.out.println(testBean3);

        MyConnection myConnection = (MyConnection) context.getBean("udara");
        System.out.println(myConnection);

    }
}