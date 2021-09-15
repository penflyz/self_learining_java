package com.udp;

import java.io.IOException;
import java.net.*;

/**
 * @author: Penflyz
 * @time: 2021/8/23 17:54
 */
public class Sender {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9998);

        byte[] bytes = "我是个猪".getBytes();

        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length,InetAddress.getByName("192.168.75.1"),9999);

        datagramSocket.send(datagramPacket);

        datagramSocket.close();

    }

}