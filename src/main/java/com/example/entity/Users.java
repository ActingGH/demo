package com.example.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户属性
 */
@Data
public class Users implements Serializable {

    //用户id 自增
    private Long id;

    //用户昵称 唯一
    private String username;

    //用户登录密码
    private String password;

    //用户手机号
    private String phone;

    //用户身份证号
    private String idNumber;

    //用户状态 删除为0 默认为1
    private Integer status;

    //用户创建时间
    private LocalDateTime createTime;

    //用户在线状态 0表示离线 1表示在线
    private Integer online;

    //用户身份 0表示管理员 1表示用户
    private Integer indentity;


}
