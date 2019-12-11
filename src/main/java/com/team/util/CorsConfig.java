package com.team.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class CorsConfig extends WebMvcConfigurationSupport {
    //跨域配置
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")                                       // 配置可以被跨域的路径，可以任意配置，可以具体到直接请求路径。
                .allowedOrigins("*")                                                   // 允许所有的请求域名访问我们的跨域资源，可以固定单条或者多条内容
                .allowCredentials(true)                                               // 允许携带Cookie信息
                .allowedMethods("GET", "POST", "DELETE", "PUT")  // 允许所有的请求方法访问该跨域资源服务器，如：POST、GET、PUT、DELETE等
                .maxAge(3600);                                                          // 预检请求的有效期，单位为秒。有效期内，不会重复发送预检请求
    }
}