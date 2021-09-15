package com.socket;



import javax.sound.midi.SoundbankResource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: Penflyz
 * @time: 2021/8/22 21:38
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("服务器端口9999 正在等待接收...");
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();

        byte[] bytes = new byte[1028];
        int line = 0;
        while ((line = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,line));
        }
        inputStream.close();
        accept.close();

    }

}

