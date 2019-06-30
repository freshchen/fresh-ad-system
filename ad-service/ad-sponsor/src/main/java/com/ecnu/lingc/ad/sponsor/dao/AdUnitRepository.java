package com.ecnu.lingc.ad.sponsor.dao;

import com.ecnu.lingc.ad.sponsor.entity.AdUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: fresh-ad-system
 * @Date: 2019/6/30 23:05
 * @Author: Ling Chen
 * @Description:
 */
public interface AdUnitRepository extends JpaRepository<AdUnit, Long> {

    AdUnit findByPlanIdAndUnitName(Long planId, String unitName);

    List<AdUnit> findAllByUnitStatus(Integer unitStatus);
}
