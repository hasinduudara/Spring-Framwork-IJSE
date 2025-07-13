package lk.hasindu;

import lk.hasindu.config.WebAppConfig;
import lk.hasindu.config.WebRootConfig;
import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    public static void main(String[] args) {
    }

    @Override
    protected Class<?> @Nullable [] getRootConfigClasses() {
        // business logic
        return new Class<?>[] { WebRootConfig.class};
    }

    @Override
    protected Class<?> @Nullable [] getServletConfigClasses() {
        // request mapping, controllers, view resolvers(child context)
        return new Class<?>[] {WebAppConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{ "/"};
    }
}