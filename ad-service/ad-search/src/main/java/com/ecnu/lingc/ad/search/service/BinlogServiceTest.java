package com.ecnu.lingc.ad.search.service;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.DeleteRowsEventData;
import com.github.shyiko.mysql.binlog.event.EventData;
import com.github.shyiko.mysql.binlog.event.UpdateRowsEventData;
import com.github.shyiko.mysql.binlog.event.WriteRowsEventData;

/**
 * @program: fresh-ad-system
 * @Date: 2019/7/6 22:08
 * @Author: Ling Chen
 * @Description:
 */

public class BinlogServiceTest {
    public BinlogServiceTest() {
    }

    public static void main(String[] args) throws Exception {
        BinaryLogClient client = new BinaryLogClient("127.0.0.1", 3306, "root", "Djangobbs");
        client.registerEventListener((event) -> {
            EventData data = event.getData();
            if (data instanceof UpdateRowsEventData) {
                System.out.println("Update--------------");
                System.out.println(data.toString());
            } else if (data instanceof WriteRowsEventData) {
                System.out.println("Write---------------");
                System.out.println(data.toString());
            } else if (data instanceof DeleteRowsEventData) {
                System.out.println("Delete--------------");
                System.out.println(data.toString());
            }

        });
        client.connect();
    }
}