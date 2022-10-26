package com.xiao.springtransaction.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiao.springtransaction.entity.Consumer;
import com.xiao.springtransaction.entity.Consumer;

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
    int update(Consumer consumer);

    /**
     * 添加数据
     *
     * @param consumer
     * @return 添加的数量
     */
    int add(Consumer consumer);
}
