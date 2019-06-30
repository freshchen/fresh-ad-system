package com.ecnu.lingc.ad.sponsor.service;

import com.ecnu.lingc.ad.common.exception.AdException;
import com.ecnu.lingc.ad.sponsor.entity.AdPlan;
import com.ecnu.lingc.ad.sponsor.vo.AdPlanGetRequest;
import com.ecnu.lingc.ad.sponsor.vo.AdPlanRequest;
import com.ecnu.lingc.ad.sponsor.vo.AdPlanResponse;

import java.util.List;

/**
 * @program: fresh-ad-system
 * @Date: 2019/6/30 18:31
 * @Author: Ling Chen
 * @Description:
 */
public interface IAdPlanService {

    /**
     * <h2>创建推广计划</h2>
     * */
    AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException;

    /**
     * <h2>获取推广计划</h2>
     * */
    List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException;

    /**
     * <h2>更新推广计划</h2>
     * */
    AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException;

    /**
     * <h2>删除推广计划</h2>
     * */
    void deleteAdPlan(AdPlanRequest request) throws AdException;
}
