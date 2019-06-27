package com.ecnu.lingc.ad.common.configration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @program: fresh-ad-system
 * @Date: 2019/6/26 22:22
 * @Author: Ling Chen
 * @Description:
 */
@Configuration
public class WebConfigration implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List <HttpMessageConverter <?>> converters) {
        converters.clear();
        // 默认转json传
        converters.add(new MappingJackson2HttpMessageConverter());
    }
}
