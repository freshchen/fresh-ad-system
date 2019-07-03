package com.ecnu.lingc.ad.sponsor.service.impl;


import com.ecnu.lingc.ad.sponsor.dao.CreativeRepository;
import com.ecnu.lingc.ad.sponsor.entity.Creative;
import com.ecnu.lingc.ad.sponsor.service.ICreativeService;
import com.ecnu.lingc.ad.sponsor.vo.CreativeRequest;
import com.ecnu.lingc.ad.sponsor.vo.CreativeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: fresh-ad-system
 * @Date: 2019/6/30 18:31
 * @Author: Ling Chen
 * @Description:
 */
@Service
public class CreativeServiceImpl implements ICreativeService {

    private final CreativeRepository creativeRepository;

    @Autowired
    public CreativeServiceImpl(CreativeRepository creativeRepository) {
        this.creativeRepository = creativeRepository;
    }

    @Override
    public CreativeResponse createCreative(CreativeRequest request) {

        Creative creative = creativeRepository.save(
                request.convertToEntity()
        );

        return new CreativeResponse(creative.getId(), creative.getName());
    }
}
