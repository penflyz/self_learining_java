package com.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author: Penflyz
 * @time: 2021/8/22 21:39
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        OutputStream outputStream = socket.getOutputStream();
        String input = "hello,pig";
        outputStream.write(input.getBytes());
        
        outputStream.close();
        socket.close();
    }
}