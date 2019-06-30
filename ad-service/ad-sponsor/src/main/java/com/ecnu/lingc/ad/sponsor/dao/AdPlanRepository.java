package com.ecnu.lingc.ad.sponsor.dao;

import com.ecnu.lingc.ad.sponsor.entity.AdPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: fresh-ad-system
 * @Date: 2019/6/30 23:05
 * @Author: Ling Chen
 * @Description:
 */
public interface AdPlanRepository extends JpaRepository<AdPlan, Long> {

    AdPlan findByIdAndUserId(Long id, Long userId);

    List<AdPlan> findAllByIdInAndUserId(List <Long> ids, Long userId);

    AdPlan findByUserIdAndPlanName(Long userId, String planName);

    List<AdPlan> findAllByPlanStatus(Integer status);
}
