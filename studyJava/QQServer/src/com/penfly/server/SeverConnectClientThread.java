package com.penfly.server;

import com.penfly.common.Message;
import com.penfly.common.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Penflyz
 * @time 2021/8/26 21:01
 */
public class SeverConnectClientThread extends Thread {
    private Socket socket;
    private String userID;

    private OffLine offLine = new OffLine();
    private ArrayList<Message> messageArrayList = new ArrayList<>();


    public Socket getSocket() {
        return socket;
    }

    public SeverConnectClientThread(String userID, Socket socket) {
        this.socket = socket;
        this.userID = userID;

    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("服务端和客户端" + userID + " 保持通信，读取数据...");

                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) objectInputStream.readObject();

                if (message.getMessageType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    System.out.println(message.getSender() + "请求在线列表...");

                    Message message1 = new Message();
                    message1.setMessageType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message1.setContend(ManageThread.getUserID());
                    message1.setGetter(message.getGetter());

                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                    objectOutputStream.writeObject(message1);

                } else if (message.getMessageType().equals(MessageType.MESSAGE_COMM_MES)) { // 私聊
                    System.out.println(message.getSender() + "请求与" + message.getGetter() + "私聊");
                    Message message1 = new Message();
                    message1.setMessageType(MessageType.MESSAGE_COMM_MES);
                    message1.setSender(message.getSender());
                    message1.setGetter(message.getGetter());
                    message1.setContend(message.getContend());
                    if (!(ManageThread.getUserID().contains(message1.getGetter()))){


                        messageArrayList.add(message1);

                        offLine.getOffLineDB().put(message.getGetter(), messageArrayList);
                        System.out.println("测试加成功没");
                    }else {
                        Socket socket1 = ManageThread.getSeverConnectClientThread(message1.getGetter()).getSocket();
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket1.getOutputStream());
                        objectOutputStream.writeObject(message1);

                    }
                }else if (message.getMessageType().equals(MessageType.MESSAGE_TO_ALL_MES)){
                    System.out.println(message.getSender() + "请求群聊");
                    Message message2 = new Message();
                    message2.setMessageType(MessageType.MESSAGE_TO_ALL_MES);
                    message2.setSender(message.getSender());
                    message2.setContend(message.getContend());

                    HashMap<String, SeverConnectClientThread> hashMap = ManageThread.getHashMap();
                    Set<String> strings = hashMap.keySet();
                    for (String s :strings) {
                        SeverConnectClientThread severConnectClientThread = hashMap.get(s);
                        Socket socket = severConnectClientThread.getSocket();
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                        objectOutputStream.writeObject(message2);
                    }
                }else if (message.getMessageType().equals(MessageType.MESSAGE_FILE_MES)){
                    System.out.println(message.getSender() + "请求发送文件给"+message.getGetter());
                    Message message3 = new Message();
                    message3.setMessageType(MessageType.MESSAGE_FILE_MES);
                    message3.setSender(message.getSender());
                    message3.setGetter(message.getGetter());
                    message3.setBytes(message.getBytes());

                    socket = ManageThread.getSeverConnectClientThread(message.getGetter()).getSocket();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                    objectOutputStream.writeObject(message3);
                }else if (message.getMessageType().equals(MessageType.MESSAGE_CLIENT_EXIT)){
                    System.out.println(message.getSender()+"退出了客户端");
                    ManageThread.removeSeverConnectClientThread(message.getSender());
                    socket.close();
                    break;
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}