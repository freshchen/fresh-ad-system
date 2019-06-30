package com.ecnu.lingc.ad.sponsor.constant;

import lombok.Getter;

/**
 * @program: fresh-ad-system
 * @Date: 2019/6/30 18:30
 * @Author: Ling Chen
 * @Description:
 */
@Getter
public enum CommonStatus {

    VALID(1, "有效状态"),
    INVALID(0, "无效状态");

    private Integer status;
    private String desc;

    CommonStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}
