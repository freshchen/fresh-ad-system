package com.ecnu.lingc.ad.sponsor.service;

import com.ecnu.lingc.ad.sponsor.vo.CreativeRequest;
import com.ecnu.lingc.ad.sponsor.vo.CreativeResponse;

/**
 * @program: fresh-ad-system
 * @Date: 2019/6/30 18:31
 * @Author: Ling Chen
 * @Description:
 */
public interface ICreativeService {

    CreativeResponse createCreative(CreativeRequest request);
}
