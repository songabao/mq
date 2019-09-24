package com.rabbitmq.entiy;

import lombok.Data;

/**
 * @author songabao
 * @date 2019-9-24 15:00
 */
@Data
public class User {
    private Integer id;
    private String name;

    public User(){}
    public User(Integer id,String name){
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString(){
        return "编号："+this.id+"  姓名："+this.name;
    }
}
