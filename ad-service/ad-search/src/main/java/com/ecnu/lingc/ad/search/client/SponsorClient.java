package com.ecnu.lingc.ad.search.client;

import com.ecnu.lingc.ad.common.vo.CommonResponse;
import com.ecnu.lingc.ad.search.vo.AdPlan;
import com.ecnu.lingc.ad.search.vo.AdPlanGetRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @program: fresh-ad-system
 * @Date: 2019/7/3 23:28
 * @Author: Ling Chen
 * @Description:
 */
@FeignClient(value = "eureka-client-ad-sponsor", fallback = SponsorClientHystrix.class)
public interface SponsorClient {

    @RequestMapping(value = "/sponsor/get/adPlan", method = RequestMethod.POST)
    CommonResponse <List <AdPlan>> getAdPlans(@RequestBody AdPlanGetRequest request);
}
