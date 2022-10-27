package com.xiao.springtransaction.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiao.springtransaction.entity.Consumer;
import com.xiao.springtransaction.entity.Consumer;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author aloneMan
 * @projectName spring-transaction
 * @createTime 2022-10-26 23:51:09
 * @description
 */
public interface ConsumerService extends IService<Consumer> {

    /**
     * 删除
     *
     * @param consumer
     *         需要删除的数据
     * @return 删除数量
     */
    int delete(Consumer consumer);

    /**
     * 更新数据
     *
     * @param consumer
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int updateRequired(Consumer consumer);

    /**
     * 事务隔离级别：REQUIRES_NEW
     *
     * @param consumer
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    int updateRequiresNew(Consumer consumer);

    /**
     * 添加数据
     *
     * @param consumer
     * @return 添加的数量
     */
    int add(Consumer consumer);
}
