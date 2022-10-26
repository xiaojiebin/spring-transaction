package com.xiao.springtransaction.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiao.springtransaction.entity.Payment;

import java.math.BigDecimal;

/**
 * @author aloneMan
 * @projectName spring-transaction
 * @createTime 2022-10-26 23:47:03
 * @description
 */
public interface PaymentService extends IService<Payment> {

    /**
     * 删除
     *
     * @param payment
     *         需要删除的数据
     * @return 删除数量
     */
    int delete(Payment payment);

    /**
     * 更新数据
     *
     * @param payment
     * @return
     */
    int update(Payment payment, BigDecimal money);

    /**
     * 添加数据
     *
     * @param payment
     * @return 添加的数量
     */
    int add(Payment payment);
}
