package com.xiao.springtransaction.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiao.springtransaction.entity.Payment;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author aloneMan
 * @projectName spring-transaction
 * @createTime 2022-10-26 23:50:04
 * @description
 */
@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {
}
