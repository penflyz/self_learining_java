package com.penfly.service;

import com.penfly.common.Message;
import com.penfly.common.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author Penflyz
 * @time 2021/8/27 11:57
 */
public class MessageClientService {
    Message message = new Message();

    public void sendOneMessage(String sender, String getter, String contend, Socket socket) {
        message.setMessageType(MessageType.MESSAGE_COMM_MES);
        message.setSender(sender);
        message.setGetter(getter);
        message.setContend(contend);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendAllMessage(String sender, String contend, Socket socket) {
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_TO_ALL_MES);
        message.setSender(sender);
        message.setContend(contend);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}