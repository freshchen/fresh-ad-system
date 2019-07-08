package com.ecnu.lingc.ad.search.search;

import com.ecnu.lingc.ad.search.search.vo.SearchRequest;
import com.ecnu.lingc.ad.search.search.vo.SearchResponse;

/**
 * @program: fresh-ad-system
 * @Date: 2019/7/6 22:11
 * @Author: Ling Chen
 * @Description:
 */
public interface ISearch {
    SearchResponse fetchAds(SearchRequest var1);
}
