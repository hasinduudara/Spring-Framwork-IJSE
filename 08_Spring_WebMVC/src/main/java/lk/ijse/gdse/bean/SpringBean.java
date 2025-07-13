package lk.ijse.gdse.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean , ApplicationContextAware {

    public SpringBean() {
        System.out.println("SpringBean instance created");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactory set in SpringBean");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name set in SpringBean: " + name);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("SpringBean is being destroyed");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("SpringBean properties have been set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContext set in SpringBean");
    }
}
