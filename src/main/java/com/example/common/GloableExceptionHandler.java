package com.example.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

@ResponseBody
@ControllerAdvice(annotations = {RestController.class})
public class GloableExceptionHandler {
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> handler(SQLIntegrityConstraintViolationException ex) {
        if (ex.getMessage().contains("Duplicate entry")) {
            String[] ms = ex.getMessage().split(" ");
            return R.error(ms[2] + "已存在");
        }
        return R.error("未知错误");
    }


}
