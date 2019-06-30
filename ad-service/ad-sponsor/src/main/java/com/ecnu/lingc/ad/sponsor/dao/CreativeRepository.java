package com.ecnu.lingc.ad.sponsor.dao;

import com.ecnu.lingc.ad.sponsor.entity.Creative;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: fresh-ad-system
 * @Date: 2019/6/30 23:05
 * @Author: Ling Chen
 * @Description:
 */
public interface CreativeRepository extends JpaRepository<Creative, Long> {
}
