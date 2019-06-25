package com.ecnu.lingc.ad.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @program: fresh-ad-system
 * @Date: 2019/6/25 21:47
 * @Author: Ling Chen
 * @Description:
 */
@Slf4j
@Component
public class PreRequestFilter extends ZuulFilter {
    @Override
    /**
     * filter类型
     */
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * order 越小优先级越高
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否执行
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        context.set("startTime", System.currentTimeMillis());
        return null;
    }
}
