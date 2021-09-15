package com.penfly.server;

import sun.dc.pr.PRError;

import java.net.Socket;
import java.util.HashMap;

/**
 * @author Penflyz
 * @time 2021/8/26 22:14
 */
public class ManageThread {
    static HashMap<String, SeverConnectClientThread> hashMap = new HashMap<>();

    public static HashMap<String, SeverConnectClientThread> getHashMap() {
        return hashMap;
    }

    public static void addThread(String userID, SeverConnectClientThread severConnectClientThread) {
        hashMap.put(userID, severConnectClientThread);
    }

    public static SeverConnectClientThread getSeverConnectClientThread(String userID){
           return hashMap.get(userID);
    }
    public static SeverConnectClientThread removeSeverConnectClientThread(String userID){
        return hashMap.remove(userID);
    }
    public static String getUserID() {
        StringBuilder list = new StringBuilder();
        for (String s : hashMap.keySet()) {
             list.append(s).append(" ");
        }
        return list.toString();
    }
}