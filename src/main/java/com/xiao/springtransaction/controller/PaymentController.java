package com.xiao.springtransaction.controller;

import com.xiao.springtransaction.entity.Payment;
import com.xiao.springtransaction.service.PaymentService;
import com.xiao.springtransaction.service.impl.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

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

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payment")
    public Integer payment(Payment payment, BigDecimal money) {
        return paymentService.update(payment, money);
    }
}
