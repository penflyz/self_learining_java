package com.socketPic;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: Penflyz
 * @time: 2021/8/23 15:23
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("等待连接中");
        Socket accept = serverSocket.accept();

        InputStream inputStream = accept.getInputStream();


        String readPath = "D:\\Desktop\\配图\\copy.jpg";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(readPath));



        byte[] bytes = new byte[10];
        int readLine = 0 ;

        while ((readLine = inputStream.read(bytes)) != -1 ){
            bufferedOutputStream.write(bytes, 0,readLine );
            System.out.println("上传成功");
        }


        inputStream.close();
        bufferedOutputStream.close();
        serverSocket.close();




    }
}