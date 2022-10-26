package com.xiao.springtransaction.entity;

import java.math.BigDecimal;

/**
 * @projectName spring-transaction
 * @author aloneMan
 * @createTime 2022-10-26 23:53:11
 * @description 
 */
public class Consumer {
    private Long id;

    private BigDecimal money;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}