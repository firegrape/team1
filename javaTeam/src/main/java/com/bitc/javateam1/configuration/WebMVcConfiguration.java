package com.bitc.javateam1.configuration;


import com.bitc.javateam1.interceptor.LoginCheck;
import com.bitc.javateam1.interceptor.MasterCheck;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class WebMVcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheck())
                //addPathPatterns():인터셉터를 동작시킬 주소 패턴 등록
                .addPathPatterns("/search/*")

                //excludePathPatterns() : 인터셉터에서 제외할 주소패턴 등록
                .excludePathPatterns("/main/minsome")
                .excludePathPatterns("/login/login.do")
                .excludePathPatterns("/login/logout.do");

        registry.addInterceptor(new MasterCheck()).addPathPatterns("/master/*");

    }
}
