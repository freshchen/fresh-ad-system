package com.ecnu.lingc.ad.sponsor.constant;

import lombok.Getter;

/**
 * @program: fresh-ad-system
 * @Date: 2019/6/30 20:07
 * @Author: Ling Chen
 * @Description:
 */
@Getter
public enum CreativeMetrialType {

    JPG(1, "jpg"),
    BMP(2, "bmp"),

    MP4(3, "mp4"),
    AVI(4, "avi"),

    TXT(5, "txt");

    private int type;
    private String desc;

    CreativeMetrialType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
