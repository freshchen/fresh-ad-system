package com.ecnu.lingc.ad.search.runner;

import com.ecnu.lingc.ad.search.mysql.BinlogClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: fresh-ad-system
 * @Date: 2019/7/8 20:52
 * @Author: Ling Chen
 * @Description:
 */
@Component
@Slf4j
public class BinlogRunner {
    private final BinlogClient client;

    @Autowired
    public BinlogRunner(BinlogClient client) {
        this.client = client;
    }

    public void run(String... strings) throws Exception {
        log.info("Coming in BinlogRunner...");
        this.client.connect();
    }
}
