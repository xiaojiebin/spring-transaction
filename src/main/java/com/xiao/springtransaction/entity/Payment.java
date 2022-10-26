package com.xiao.springtransaction.entity;

/**
 * @projectName spring-transaction
 * @author aloneMan
 * @createTime 2022-10-26 23:44:04
 * @description 
 */
public class Payment {
    private Long id;

    private String serial;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}