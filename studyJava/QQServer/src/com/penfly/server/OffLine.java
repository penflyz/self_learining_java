package com.penfly.server;

import com.penfly.common.Message;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author  Penflyz
 * @time  2021/8/30 18:48
 */
public class OffLine {
    private static ConcurrentHashMap<String, ArrayList<Message>> offLineDB = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, ArrayList<Message>> getOffLineDB() {
        return offLineDB;
    }


}