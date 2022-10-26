package com.xiao.springtransaction.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aloneMan
 * @projectName spring-transaction
 * @createTime 2022-10-26 23:44:26
 * @description
 */

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class PaymentController {

    @GetMapping("/payment/{serial}")
    public void payment(@PathVariable("serial")String serial){

    }
}
