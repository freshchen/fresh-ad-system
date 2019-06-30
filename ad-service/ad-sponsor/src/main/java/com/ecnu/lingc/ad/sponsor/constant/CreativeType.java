package com.ecnu.lingc.ad.sponsor.constant;

import lombok.Getter;

/**
 * @program: fresh-ad-system
 * @Date: 2019/6/30 20:07
 * @Author: Ling Chen
 * @Description:
 */
@Getter
public enum  CreativeType {

    IMAGE(1, "图片"),
    VIDEO(2, "视频"),
    TEXT(3, "文本");

    private int type;
    private String desc;

    CreativeType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
