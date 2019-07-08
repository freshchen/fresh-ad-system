package com.ecnu.lingc.ad.search.search.vo;


import com.ecnu.lingc.ad.search.search.vo.feature.DistrictFeature;
import com.ecnu.lingc.ad.search.search.vo.feature.FeatureRelation;
import com.ecnu.lingc.ad.search.search.vo.feature.ItFeature;
import com.ecnu.lingc.ad.search.search.vo.feature.KeywordFeature;
import com.ecnu.lingc.ad.search.search.vo.media.AdSlot;
import com.ecnu.lingc.ad.search.search.vo.media.App;
import com.ecnu.lingc.ad.search.search.vo.media.Device;
import com.ecnu.lingc.ad.search.search.vo.media.Geo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: fresh-ad-system
 * @Date: 2019/6/30 18:31
 * @Author: Ling Chen
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequest {

    // 媒体方的请求标识
    private String mediaId;
    // 请求基本信息
    private RequestInfo requestInfo;
    // 匹配信息
    private FeatureInfo featureInfo;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestInfo {

        private String requestId;

        private List<AdSlot> adSlots;
        private App app;
        private Geo geo;
        private Device device;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FeatureInfo {

        private KeywordFeature keywordFeature;
        private DistrictFeature districtFeature;
        private ItFeature itFeature;

        private FeatureRelation relation = FeatureRelation.AND;
    }
}
