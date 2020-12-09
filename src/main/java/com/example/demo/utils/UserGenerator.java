package com.example.demo.utils;

import java.util.Collections;
import java.util.List;

public class UserGenerator extends Proxy {
    public String makeUserid(){
        var tx = List.of("a", "b", "c", "d", "e", "f", 
                                            "g", "h", "i", "j", "k", "l", "n", "m", "o",
                                            "p", "q", "r", "s", "t", "u", "v", "w", "x",
                                            "y", "z", "1", "2", "3", "4", "5", "6", "7",
                                            "8", "9","0");
        Collections.shuffle(tx);
        return String.format("%s%s%s%s%s",tx.get(0),tx.get(1),
                            tx.get(2),tx.get(3),tx.get(4));
    }
}
