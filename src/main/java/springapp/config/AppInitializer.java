package springapp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import springapp.config.security.WebSecurityConfig;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class < ? > [] getRootConfigClasses() {
        return new Class[] {
                AppContext.class,WebMvcConfig.class,WebSecurityConfig.class
        };
        //return null;
    }

    @Override
    protected Class < ? > [] getServletConfigClasses() {
        return new Class[] {
                WebMvcConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {
                "/"
        };
    }
}
