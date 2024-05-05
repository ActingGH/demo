package com.example.common;

import lombok.Data;

@Data
public class PageParam {
    //页码
    public Integer page;
    //每页条数
    public Integer pageSize;
    //用户名
    public String userName;
    //手机号
    public String phone;
    //状态
    public Integer status;
    //身份证号
    public String idNumber;
    //id
    public String id;
}
