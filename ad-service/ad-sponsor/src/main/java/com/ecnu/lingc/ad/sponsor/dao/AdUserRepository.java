package com.ecnu.lingc.ad.sponsor.dao;

import com.ecnu.lingc.ad.sponsor.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: fresh-ad-system
 * @Date: 2019/6/30 23:05
 * @Author: Ling Chen
 * @Description:
 */
public interface AdUserRepository extends JpaRepository <AdUser, Long> {

    /**
     * 根据用户名查找用户记录
     * */
    AdUser findByUsername(String username);
}
