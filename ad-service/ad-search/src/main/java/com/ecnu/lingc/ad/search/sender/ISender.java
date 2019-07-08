package com.ecnu.lingc.ad.search.sender;

import com.ecnu.lingc.ad.search.mysql.dto.MySqlRowData;

/**
 * @program: fresh-ad-system
 * @Date: 2019/7/6 22:09
 * @Author: Ling Chen
 * @Description:
 */
public interface ISender {
    void sender(MySqlRowData var1);
}
