package com.socketPic;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author: Penflyz
 * @time: 2021/8/23 15:23
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        OutputStream outputStream = socket.getOutputStream();

        String filePath = "D:\\Desktop\\配图\\20210203221752_17108.jpg";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));

        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

        outputStream.write(bytes);

        bufferedInputStream.close();
        outputStream.close();
        socket.close();
    }
}