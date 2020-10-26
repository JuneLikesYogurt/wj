package com.jun1.wj.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyWebConfigurer implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)     // 允许跨域使用 cookie
                .allowedOrigins("http://localhost:8080")        // 不使用通配符 *，出于安全上的考虑。
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowedHeaders("*");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api/file/**").addResourceLocations("file:" + "D:\\Project\\wj\\src\\main\\resources\\static\\img\\");
    }

    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLoginIntercepter())
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html")
                .excludePathPatterns("/api/login")
                .excludePathPatterns("/api/logout");
    }*/

}
