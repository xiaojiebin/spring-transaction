package com.xiao.springtransaction.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiao.springtransaction.dao.PaymentMapper;
import com.xiao.springtransaction.entity.Consumer;
import com.xiao.springtransaction.entity.Payment;
import com.xiao.springtransaction.service.ConsumerService;
import com.xiao.springtransaction.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
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
@Slf4j
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

    /**
     * 模式事务传播性 REQUIRED 如果当前存在事务，则使用当前事务，如果没有则创建一个新的事务
     * REQUIRES传播性，在当前方法或者调用方法中，发生异常，在当前事务中的所有的数据库操作多会回滚。
     *
     * @param payment
     * @param money
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateRequired(Payment payment, BigDecimal money) {
        QueryWrapper<Payment> query = getPaymentQueryWrapper(payment);
        int update = super.baseMapper.update(payment, query);
        Consumer consumer = getConsumer(payment, money);
        int update1 = 0;
        try {
            update1 = consumerService.updateRequiresNew(consumer);
        } catch (Exception e) {
            log.info("{} ", "我对此次异常进行了处理");
        }
        if (new BigDecimal("99.999").compareTo(money) == 0) {
            int i = 1 / 0;
        }
        return update + update1;
    }


    /**
     * REQUIRES_NEW：如果当前存在事务，则将此事务挂起，创建一个新的事务
     * 此传播级别，如果调用的方法是REQUIRES_NEW隔离级别，如果出现异常，对异常进行处理，则当前方法不会回滚，如果不处理则会回滚
     *
     * @param payment
     * @param money
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int updateRequiresNew(Payment payment, BigDecimal money) {
        QueryWrapper<Payment> query = getPaymentQueryWrapper(payment);
        int update = super.baseMapper.update(payment, query);
        Consumer consumer = getConsumer(payment, money);
        int update1 = 0;
        try {
            update1 = consumerService.updateRequiresNew(consumer);
        } catch (Exception e) {
            log.info("{} ", "我对此次异常进行了处理");
//            throw new RuntimeException(e);
        }

        if (new BigDecimal("99.999").compareTo(money) == 0) {
            int i = 1 / 0;
        }
        return update + update1;
    }

    @Override
    public int updateNesetd(Payment payment, BigDecimal money) {
        return 0;
    }

    @NotNull
    private static Consumer getConsumer(Payment payment, BigDecimal money) {
        Consumer consumer = new Consumer();
        consumer.setId(payment.getId());
        consumer.setMoney(money);
        return consumer;
    }


    @NotNull
    private static QueryWrapper<Payment> getPaymentQueryWrapper(Payment payment) {
        QueryWrapper<Payment> query = new QueryWrapper<>();
        query.eq("id", payment.getId());
        return query;
    }


    @Override
    public int add(Payment payment) {
        return 0;
    }
}
