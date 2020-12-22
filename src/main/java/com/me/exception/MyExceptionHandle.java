package com.me.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MyExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public Object handle1(Exception e, HttpServletRequest request) {
        System.out.println("handle1");

        Map<String, Object> map = new HashMap<>();
        map.put("msg", e.getMessage());
        map.put("url", request.getRequestURL());
        return map;
    }

    @ExceptionHandler(value = MyException.class)
    public Object handle2(Exception e, HttpServletRequest request) {
        System.out.println("zi ding yi yi chang");
        Map<String, Object> map = new HashMap<>();
        map.put("msg", e.getMessage());
        map.put("url", request.getRequestURL());
        return map;
    }
}
