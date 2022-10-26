package com.xiao.springtransaction.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiao.springtransaction.entity.Consumer;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author aloneMan
 * @projectName spring-transaction
 * @createTime 2022-10-26 23:53:54
 * @description
 */
@Mapper
public interface ConsumerMapper extends BaseMapper<Consumer> {
}
