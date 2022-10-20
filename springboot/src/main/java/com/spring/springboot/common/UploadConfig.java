package com.spring.springboot.common;


import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;


@Configuration
    public class UploadConfig {

        @Bean
        public MultipartConfigElement multipartConfigElement() {
            MultipartConfigFactory factory = new MultipartConfigFactory();
            //  单个数据大小
        //    factory.setMaxFileSize("10240KB");
            /// 总上传数据大小
          //  factory.setMaxRequestSize("102400KB");
            return factory.createMultipartConfig();
        }
    }
