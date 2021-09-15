package com.penfly.service;

import com.penfly.common.Message;
import com.penfly.common.MessageType;

import java.io.*;
import java.net.Socket;

/**
 * @author  Penflyz
 * @time  2021/8/26 19:05
 * 让客户端一直保持和服务端互相接通
 * 所以
 */
public class ClientConnectSeverThread extends Thread {
    public Socket getSocket() {
        return socket;
    }


    private Socket socket;


    public ClientConnectSeverThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("客户端接受服务端信息中...");
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) objectInputStream.readObject();
                String messageType = message.getMessageType();
                //显示在线列表
                if (messageType.equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {
                    System.out.println("============当前好友列表===========");
                    String[] contend = message.getContend().split(" ");
                    for (int i = 0; i < contend.length; i++) {
                        System.out.println((i+1)+ "  " + contend[i]);
                    }
                }else if (messageType.equals(MessageType.MESSAGE_COMM_MES)){  //私发
                    System.out.println(message.getSender()+"对"+message.getGetter()+"说:" + message.getContend());
                }else if (messageType.equals(MessageType.MESSAGE_TO_ALL_MES)){ //群发
                    System.out.println(message.getSender() + "对大家说：" + message.getContend());
                }else if(messageType.equals(MessageType.MESSAGE_FILE_MES)){  //发送文件

                    byte[] bytes = message.getBytes();
//                    System.out.print("请输入要保存文件的位置：");
//                    String dest = Utility.readString(50);
                    String dest = "d:\\Desktop\\copy1.jpg";
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(dest));
                    bufferedOutputStream.write(bytes);

                    bufferedOutputStream.close(); // 切记关闭，不然写入不了

                    System.out.println(message.getSender()+"给"+message.getGetter()+"发送文件成功");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}