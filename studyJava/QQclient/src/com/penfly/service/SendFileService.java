package com.penfly.service;

import com.penfly.common.Message;
import com.penfly.common.MessageType;

import java.awt.*;
import java.io.*;
import java.net.Socket;

/**
 * @author  Penflyz
 * @time  2021/8/28 10:15
 */
public class SendFileService {

    private FileInputStream fileInputStream  = null;
    public void sendFileToOne(String sender, String getter, Socket socket, String src) {

        Message message = new Message();
        message.setSender(sender);
        message.setGetter(getter);
        message.setMessageType(MessageType.MESSAGE_FILE_MES);
        message.setSrc(src);

        try {
            fileInputStream = new FileInputStream(src);
            File file = new File(src);

            byte[] bytes = new byte[(int) file.length()];
            fileInputStream.read(bytes);
            message.setBytes(bytes);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(message);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
           if (fileInputStream != null){
               try {
                   fileInputStream.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }



    }
}