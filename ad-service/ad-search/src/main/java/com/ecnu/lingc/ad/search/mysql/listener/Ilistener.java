package com.ecnu.lingc.ad.search.mysql.listener;


import com.ecnu.lingc.ad.search.mysql.dto.BinlogRowData;

/**
 * @program: fresh-ad-system
 * @Date: 2019/6/30 18:31
 * @Author: Ling Chen
 * @Description:
 */
public interface Ilistener {

    void register();

    void onEvent(BinlogRowData eventData);
}
