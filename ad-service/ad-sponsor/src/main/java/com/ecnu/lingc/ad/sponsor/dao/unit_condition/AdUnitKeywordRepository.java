package com.ecnu.lingc.ad.sponsor.dao.unit_condition;

import com.ecnu.lingc.ad.sponsor.entity.unit_condition.AdUnitKeyword;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: fresh-ad-system
 * @Date: 2019/6/30 23:05
 * @Author: Ling Chen
 * @Description:
 */
public interface AdUnitKeywordRepository extends
        JpaRepository<AdUnitKeyword, Long> {
}
