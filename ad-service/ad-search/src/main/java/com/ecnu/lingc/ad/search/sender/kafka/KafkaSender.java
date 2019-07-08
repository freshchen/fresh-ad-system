package com.ecnu.lingc.ad.search.sender.kafka;

import com.alibaba.fastjson.JSON;
import com.ecnu.lingc.ad.search.mysql.dto.MySqlRowData;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @program: fresh-ad-system
 * @Date: 2019/7/8 21:55
 * @Author: Ling Chen
 * @Description:
 */
@Slf4j
@Component("kafkaSender")
public class KafkaSender {
    @Value("${adconf.kafka.topic}")
    private String topic;
    private final KafkaTemplate <String, String> kafkaTemplate;

    @Autowired
    public KafkaSender(KafkaTemplate <String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sender(MySqlRowData rowData) {
        this.kafkaTemplate.send(this.topic, JSON.toJSONString(rowData));
    }

    @KafkaListener(topics = {"ad-search-mysql-data"}, groupId = "ad-search")
    public void processMysqlRowData(ConsumerRecord <?, ?> record) {
        Optional <?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            MySqlRowData rowData = (MySqlRowData) JSON.parseObject(message.toString(), MySqlRowData.class);
            log.debug("kafka processMysqlRowData: " + JSON.toJSONString(rowData));
        }

    }
}
