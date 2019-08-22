package com.imooc.sm.entity;

import java.util.Date;

public class Log {

    private Date operTime;
    private String type;
    private String operator;
    private String moudle;
    private String operation;
    private String result;

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getMoudle() {
        return moudle;
    }

    public void setMoudle(String moudle) {
        this.moudle = moudle;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Log{" +
                "operTime=" + operTime +
                ", type='" + type + '\'' +
                ", operator='" + operator + '\'' +
                ", moudle='" + moudle + '\'' +
                ", operation='" + operation + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
