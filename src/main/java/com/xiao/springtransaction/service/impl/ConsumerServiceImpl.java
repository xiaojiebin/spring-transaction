package com.xiao.springtransaction.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiao.springtransaction.dao.ConsumerMapper;
import com.xiao.springtransaction.entity.Consumer;
import com.xiao.springtransaction.service.ConsumerService;
import org.springframework.stereotype.Service;

/**
 * @author aloneMan
 * @projectName spring-transaction
 * @createTime 2022-10-26 23:52:07
 * @description
 */
@Service("consumerService")
public class ConsumerServiceImpl extends ServiceImpl<ConsumerMapper, Consumer> implements ConsumerService {
}
