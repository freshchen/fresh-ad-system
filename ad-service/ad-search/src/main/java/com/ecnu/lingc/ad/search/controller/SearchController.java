package com.ecnu.lingc.ad.search.controller;

import com.alibaba.fastjson.JSON;
import com.ecnu.lingc.ad.common.annotatiion.IgnoreResponseAdvice;
import com.ecnu.lingc.ad.common.vo.CommonResponse;
import com.ecnu.lingc.ad.search.client.SponsorClient;
import com.ecnu.lingc.ad.search.search.ISearch;
import com.ecnu.lingc.ad.search.search.vo.SearchRequest;
import com.ecnu.lingc.ad.search.search.vo.SearchResponse;
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

    private final ISearch search;

    private final RestTemplate restTemplate;

    private final SponsorClient sponsorClient;

    @Autowired
    public SearchController(RestTemplate restTemplate,
                            SponsorClient sponsorClient, ISearch search) {
        this.restTemplate = restTemplate;
        this.sponsorClient = sponsorClient;
        this.search = search;
    }

    @PostMapping("/fetchAds")
    public SearchResponse fetchAds(@RequestBody SearchRequest request) {

        log.info("ad-search: fetchAds -> {}",
                JSON.toJSONString(request));
        return search.fetchAds(request);
    }

    @IgnoreResponseAdvice
    @PostMapping("/getAdPlans")
    public CommonResponse<List<AdPlan>> getAdPlans(
            @RequestBody AdPlanGetRequest request
    ) {
        log.info("ad-search: getAdPlans -> {}",
                JSON.toJSONString(request));
        return sponsorClient.getAdPlans(request);
    }

    @SuppressWarnings("all")
    @IgnoreResponseAdvice
    @PostMapping("/getAdPlansByRibbon")
    public CommonResponse<List<AdPlan>> getAdPlansByRebbon(
            @RequestBody AdPlanGetRequest request
    ) {
        log.info("ad-search: getAdPlansByRibbon -> {}",
                JSON.toJSONString(request));
        return restTemplate.postForEntity(
                "http://eureka-client-ad-sponsor/ad-sponsor/get/adPlan",
                request,
                CommonResponse.class
        ).getBody();
    }
}
