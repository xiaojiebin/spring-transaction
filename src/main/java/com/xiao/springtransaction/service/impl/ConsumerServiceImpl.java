package com.xiao.springtransaction.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiao.springtransaction.dao.ConsumerMapper;
import com.xiao.springtransaction.entity.Consumer;
import com.xiao.springtransaction.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author aloneMan
 * @projectName spring-transaction
 * @createTime 2022-10-26 23:52:07
 * @description
 */
@Service("consumerService")
@Slf4j
public class ConsumerServiceImpl extends ServiceImpl<ConsumerMapper, Consumer> implements ConsumerService {
    @Override
    public int delete(Consumer consumer) {
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int updateRequired(Consumer consumer) {
        QueryWrapper<Consumer> query = new QueryWrapper<>();
        query.eq("id", consumer.getId());
        int update = super.baseMapper.update(consumer, query);
        int i1 = new BigDecimal("88.888").compareTo(consumer.getMoney());
        if (i1 == 0) {
            int i = 1 / 0;
        }
        return update;
    }

    @Override
    public int updateRequiresNew(Consumer consumer) {
        QueryWrapper<Consumer> query = new QueryWrapper<>();
        query.eq("id", consumer.getId());
        int update = super.baseMapper.update(consumer, query);
        int i1 = new BigDecimal("88.888").compareTo(consumer.getMoney());
        if (i1 == 0) {
            int i = 1 / 0;
        }
        return update;
    }

    @Override
    public int add(Consumer consumer) {
        return 0;
    }
}
