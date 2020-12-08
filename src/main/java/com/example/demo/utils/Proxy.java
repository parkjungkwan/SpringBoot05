package com.example.demo.utils;

import java.util.function.Function;

import org.springframework.stereotype.Component;

@Component
public class Proxy {
    public int integer(String t){
        Function<String, Integer> f = Integer::parseInt;
        return f.apply(t);
    }
    public String string(Object t){
        return "";
    }
}
