package com.ecnu.lingc.ad.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @program: fresh-ad-system
 * @Date: 2019/6/25 21:58
 * @Author: Ling Chen
 * @Description:
 */
@Slf4j
@Component
public class PostRequestFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        String url = context.getRequest().getRequestURI();
        long duration = System.currentTimeMillis() - (Long) context.get("startTime");
        log.info("url: [{}] duration: [{}]", url, duration);
        return null;
    }
}
