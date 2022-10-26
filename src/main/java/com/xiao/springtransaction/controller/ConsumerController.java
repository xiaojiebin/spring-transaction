package com.xiao.springtransaction.controller;

import com.xiao.springtransaction.entity.Consumer;
import com.xiao.springtransaction.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author aloneMan
 * @projectName spring-transaction
 * @createTime 2022-10-26 23:58:32
 * @description
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class ConsumerController {

    private final ConsumerService service;

    public ConsumerController(ConsumerService consumerService) {
        this.service = consumerService;
    }

    @GetMapping("/add/{money}")
    public String add(@PathVariable("money") BigDecimal money) {
        log.info("{} ", money);
        Consumer consumer = new Consumer();
        consumer.setMoney(money);
        service.save(consumer);
        return "成功了";
    }
}
