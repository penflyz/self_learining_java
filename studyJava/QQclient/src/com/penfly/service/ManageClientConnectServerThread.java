package com.penfly.service;

import java.util.HashMap;

/**
 * @author 韩顺平
 * @version 1.0
 * 该类管理客户端连接到服务器端的线程的类
 */
public class ManageClientConnectServerThread {
    public static HashMap<String, ClientConnectSeverThread> getHm() {
        return hm;
    }

    //我们把多个线程放入一个HashMap集合，key 就是用户id, value 就是线程
    private static HashMap<String, ClientConnectSeverThread> hm = new HashMap<>();

    //将某个线程加入到集合
    public static void addClientConnectServerThread(String userId, ClientConnectSeverThread clientConnectServerThread) {
        hm.put(userId, clientConnectServerThread);
    }
    //通过userId 可以得到对应线程
    public static ClientConnectSeverThread getClientConnectServerThread(String userId) {
        return hm.get(userId);
    }

    }




