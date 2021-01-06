package com.wqh.kafka.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName ProducerController
 * @Author wqh
 * @Date 2021/1/6 14:31
 * @Description TODO
 * @Version 1.0
 */
@RestController
public class ProducerController {
    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    @RequestMapping("/message/send")
    public String send(String msg) {
        kafkaTemplate.send("test", msg); //使用kafka模板发送信息
        return "success";
    }


}
