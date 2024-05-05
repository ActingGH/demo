package com.example.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R<T> {
    //1 成功 0失败
    private Integer code;
    //传输状态信息
    private String msg;
    //创术封装的数据
    private T data;
    private Map map=new HashMap();
    public static <T> R<T> success(T object){
        R<T> r=new R<T>();
        r.data=object;
        r.code=1;
        return r;
    }

    public static <T> R<T> error(String meg) {
        R r = new R();
        r.msg = meg;
        r.code=0;
        return r;

    }
}
