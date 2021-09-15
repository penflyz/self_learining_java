package com.penfly.service;

import com.penfly.common.Message;

import com.penfly.common.MessageType;
import com.penfly.common.User;
import com.penfly.view.QQView;


import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;


/**
 * @author Penflyz
 * @time 2021/8/26 12:46
 */
public class UserClientService {
    User user = new User();
    Socket socket;

    private boolean key = true;

    public void setKey(boolean key) {
        this.key = key;
    }

    public Socket getSocket() {
        return socket;
    }


    public boolean checkUser(String ID, String pwd) {
        user.setPwd(pwd);
        user.setUserID(ID);

        try {
            //帐号密码发过去
            Socket socket = new Socket(InetAddress.getLocalHost(), 9998);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(user);
            //返回回来  一个message标志
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Message message1 = (Message) objectInputStream.readObject();
            if (MessageType.MESSAGE_LOGIN_SUCCEED.equals(message1.getMessageType())) {
                ClientConnectSeverThread clientConnectSeverThread = new ClientConnectSeverThread(socket);
                clientConnectSeverThread.start();
                ManageClientConnectServerThread.addClientConnectServerThread(
                        user.getUserID(), clientConnectSeverThread);
                return true;
            }else {
                socket.close();
            }


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //登录失败
        return false;
    }

    public void showOnlineFriend(){
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(user.getUserID());

        try {
            ClientConnectSeverThread clientConnectServerThread =
                    ManageClientConnectServerThread.getClientConnectServerThread(user.getUserID());
            Socket socket = clientConnectServerThread.getSocket();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exitSys(){
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(user.getUserID());

        try {
            ClientConnectSeverThread clientConnectServerThread =
                    ManageClientConnectServerThread.getClientConnectServerThread(user.getUserID());
            Socket socket1 = clientConnectServerThread.getSocket();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket1.getOutputStream());
            objectOutputStream.writeObject(message);
            System.exit(0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }




