package com.penfly.server;

import com.penfly.common.Message;
import com.penfly.common.MessageType;
import com.penfly.utils.Utility;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Set;

/**
 * @author Penflyz
 * @time 2021/8/30 17:24
 */
public class SeverSendNews implements Runnable{
    private ObjectOutputStream objectOutputStream = null;
    @Override
    public void run() {
        Message message = new Message();
        System.out.print("请输入你要推送的信息：");
        String news = Utility.readString(100);
        message.setSender("服务器");
        message.setContend(news);
        message.setMessageType(MessageType.MESSAGE_TO_ALL_MES);

        Set<String> strings = ManageThread.getHashMap().keySet();
        for (String o : strings) {
            try {
                Socket socket = ManageThread.getSeverConnectClientThread(o).getSocket();
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
