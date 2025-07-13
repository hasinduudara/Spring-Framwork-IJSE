package lk.ijse.gdse.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyConnection implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    // the state of the object creation
    public  MyConnection() {
        System.out.println("MyConnection Constructor called");
    }

    // there os on method find stste of the prpoperties


    // Bean name aware (Bean ID)
    @Override
    public void setBeanName(String name) {
        System.out.println("MyConnection setBeanName Constructor called");
    }

    // Bean factory aware (ID)
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("MyConnection setBeanFactory Constructor called");
    }

    // Application context aware (AOP and DP)
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("MyConnection setApplicationContext Constructor called");
    }

    // Initializing bean (after properties set)
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyConnection afterPropertiesSet Constructor called");
    }

    // Disposable bean (destroy method)
    @Override
    public void destroy() throws Exception {
        System.out.println("MyConnection is destroy");
    }

}
