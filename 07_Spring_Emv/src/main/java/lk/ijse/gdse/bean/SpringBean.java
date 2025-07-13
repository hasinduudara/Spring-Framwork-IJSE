package lk.ijse.gdse.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBean implements InitializingBean {

    @Value("${os.name}")
    private String osName;

    @Value("${user.name}")
    private String LOGNAME ;

    @Value("${db.name}")
    private String dbName;

    @Value("${db.user}")
    private String dbUser;

    @Value("${db.password}")
    private String dbPassword;

    @Value("${db.url}")
    private String dbUrl;


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(osName);
        System.out.println(LOGNAME);
        System.out.println(dbName);
        System.out.println(dbUser);
        System.out.println(dbPassword);
        System.out.println(dbUrl);
    }
}
