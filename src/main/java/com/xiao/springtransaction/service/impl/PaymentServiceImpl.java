package com.xiao.springtransaction.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiao.springtransaction.dao.PaymentMapper;
import com.xiao.springtransaction.entity.Payment;
import com.xiao.springtransaction.service.PaymentService;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author aloneMan
 * @projectName spring-transaction
 * @createTime 2022-10-26 23:46:50
 * @description
 */
@Service("paymentService")
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {
}
