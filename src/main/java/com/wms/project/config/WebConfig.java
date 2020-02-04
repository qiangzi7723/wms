package com.wms.project.config;

import com.wms.project.config.Interceptors.CommonResponse;
import com.wms.project.config.Interceptors.JwtInterceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private JwtInterceptors jwtInterceptors;

    @Autowired
    private CommonResponse commonResponse;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptors).addPathPatterns("/**")
                .excludePathPatterns("/noJwt");

        registry.addInterceptor(commonResponse).addPathPatterns("/**");
    }
}
