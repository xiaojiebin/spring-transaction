package com.xiao.springtransaction.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiao.springtransaction.dao.PaymentMapper;
import com.xiao.springtransaction.entity.Consumer;
import com.xiao.springtransaction.entity.Payment;
import com.xiao.springtransaction.service.ConsumerService;
import com.xiao.springtransaction.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author aloneMan
 * @projectName spring-transaction
 * @createTime 2022-10-26 23:46:50
 * @description
 */
@Service("paymentService")
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {

    private ConsumerService consumerService;

    public PaymentServiceImpl(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @Override
    public int delete(Payment payment) {
        int i = super.baseMapper.deleteById(payment.getId());
        return i;
    }

    @Override
//    @Transactional(propagation = Propagation.REQUIRED,
//    isolation = Isolation.REPEATABLE_READ,
//    rollbackFor = Exception.class)
    public int update(Payment payment, BigDecimal money) {
        QueryWrapper<Payment> query = new QueryWrapper<>();
        query.eq("id", payment.getId());
        int update = super.baseMapper.update(payment, query);
        Consumer consumer = new Consumer();
        consumer.setId(payment.getId());
        consumer.setMoney(money);
        int update1 = consumerService.update(consumer);
        return update + update1;
    }

    @Override
    public int add(Payment payment) {
        return 0;
    }
}
