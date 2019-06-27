package com.ecnu.lingc.ad.common.advice;

import com.ecnu.lingc.ad.common.exception.AdException;
import com.ecnu.lingc.ad.common.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: fresh-ad-system
 * @Date: 2019/6/26 22:16
 * @Author: Ling Chen
 * @Description:
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(AdException.class)
    public CommonResponse handlerAdException(HttpServletRequest request, AdException e){
        CommonResponse<String> response = new CommonResponse <>(-1, "ERROR");
        response.setData(e.getMessage());
        return response;
    }
}
