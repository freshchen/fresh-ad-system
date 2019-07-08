package com.ecnu.lingc.ad.search.index;

import lombok.Getter;

/**
 * @program: fresh-ad-system
 * @Date: 2019/7/8 21:16
 * @Author: Ling Chen
 * @Description:
 */
@Getter
public enum  DataLevel {

    LEVEL2("2", "Level 2"),
    LEVEL3("3", "Level 3"),
    LEVEL4("4", "Level 4");

    private String level;
    private String desc;

    DataLevel(String level, String desc) {
        this.level = level;
        this.desc = desc;
    }
}
