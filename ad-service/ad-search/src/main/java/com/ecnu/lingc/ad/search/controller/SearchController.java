package com.ecnu.lingc.ad.search.controller;

import com.alibaba.fastjson.JSON;
import com.ecnu.lingc.ad.common.annotatiion.IgnoreResponseAdvice;
import com.ecnu.lingc.ad.common.vo.CommonResponse;
import com.ecnu.lingc.ad.search.client.SponsorClient;
import com.ecnu.lingc.ad.search.vo.AdPlan;
import com.ecnu.lingc.ad.search.vo.AdPlanGetRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @program: fresh-ad-system
 * @Date: 2019/7/3 22:23
 * @Author: Ling Chen
 * @Description:
 */
@Slf4j
@RestController
public class SearchController {

    private final RestTemplate restTemplate;
    private final SponsorClient sponsorClient;

    @Autowired
    public SearchController(RestTemplate restTemplate, SponsorClient sponsorClient) {
        this.restTemplate = restTemplate;
        this.sponsorClient = sponsorClient;
    }

    @IgnoreResponseAdvice
    @PostMapping("/get/adPlansByRibbon")
    @SuppressWarnings("all")
    public CommonResponse <List <AdPlan>> getAdPlansByRibbon(@RequestBody AdPlanGetRequest request) {
        log.info("ad-search: getAdPlansByRibbon -> [{}]", JSON.toJSONString(request));
        return restTemplate.postForEntity("http://eureka-client-ad-sponsor/get/adPlan", request, CommonResponse.class).getBody();
    }

    @IgnoreResponseAdvice
    @PostMapping("/get/adPlansByFeign")
    public CommonResponse <List <AdPlan>> getAdPlansByFeign(@RequestBody AdPlanGetRequest request) {
        log.info("ad-search: getAdPlansByRibbon -> [{}]", JSON.toJSONString(request));
        return sponsorClient.getAdPlans(request);
    }
}
