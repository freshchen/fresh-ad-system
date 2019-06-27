package com.ecnu.lingc.ad.common.advice;

import com.ecnu.lingc.ad.common.annotatiion.IgnoreResponseAdvice;
import com.ecnu.lingc.ad.common.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @program: fresh-ad-system
 * @Date: 2019/6/26 21:08
 * @Author: Ling Chen
 * @Description:
 */
@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice <Object> {

    /**
     * 拦截过滤
     *
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class <? extends HttpMessageConverter <?>> aClass) {
        // 加了IgnoreResponseAdvice注解不统一处理
        if (methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class) || methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        return true;
    }

    @Override
    @Nullable
    public Object beforeBodyWrite(@Nullable Object o, MethodParameter methodParameter, MediaType mediaType, Class <? extends HttpMessageConverter <?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        CommonResponse <Object> response = new CommonResponse <>(0, "");
        if (null == o){
            return response;
        }else if (o instanceof CommonResponse){
            response = (CommonResponse <Object>) o;
        }else {
            response.setData(o);
        }
        return response;
    }
}
