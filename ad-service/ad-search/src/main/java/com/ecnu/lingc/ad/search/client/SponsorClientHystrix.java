package com.ecnu.lingc.ad.search.client;

import com.ecnu.lingc.ad.common.vo.CommonResponse;
import com.ecnu.lingc.ad.search.vo.AdPlan;
import com.ecnu.lingc.ad.search.vo.AdPlanGetRequest;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: fresh-ad-system
 * @Date: 2019/7/3 23:35
 * @Author: Ling Chen
 * @Description:
 */
@Component
public class SponsorClientHystrix implements SponsorClient {
    @Override
    public CommonResponse <List <AdPlan>> getAdPlans(AdPlanGetRequest request) {
        return new CommonResponse <>(-1, "eureka-client-ad-sponsor error");
    }
}
