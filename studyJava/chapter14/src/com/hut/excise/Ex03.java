package com.hut.excise;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.HashMap;
import java.util.Set;

@SuppressWarnings({"all"})
public class Ex03 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("jack", 650);
        hashMap.put("tom", 1200);
        hashMap.put("smith", 2000);

        hashMap.put("jack", 2600);

        Set set = hashMap.keySet();
        for (Object o :set) {
            hashMap.put(o,(Integer)hashMap.get(o)+100);
        }
        System.out.println(hashMap);
    }
}
