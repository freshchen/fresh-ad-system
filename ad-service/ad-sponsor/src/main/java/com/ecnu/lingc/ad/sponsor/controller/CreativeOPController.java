package com.ecnu.lingc.ad.sponsor.controller;

import com.alibaba.fastjson.JSON;
import com.ecnu.lingc.ad.sponsor.service.ICreativeService;
import com.ecnu.lingc.ad.sponsor.vo.CreativeRequest;
import com.ecnu.lingc.ad.sponsor.vo.CreativeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: fresh-ad-system
 * @Date: 2019/6/30 18:31
 * @Author: Ling Chen
 * @Description:
 */
@Slf4j
@RestController
public class CreativeOPController {

    private final ICreativeService creativeService;

    @Autowired
    public CreativeOPController(ICreativeService creativeService) {
        this.creativeService = creativeService;
    }

    @PostMapping("/create/creative")
    public CreativeResponse createCreative(
            @RequestBody CreativeRequest request
            ) {
        log.info("ad-sponsor: createCreative -> {}",
                JSON.toJSONString(request));
        return creativeService.createCreative(request);
    }
}
