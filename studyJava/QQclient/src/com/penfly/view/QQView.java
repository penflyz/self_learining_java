package com.penfly.view;

import com.penfly.service.*;
import com.penfly.utils.Utility;
import org.junit.Test;
import sun.dc.pr.PRError;
import sun.security.util.AuthResources_it;

import java.net.Socket;
import java.util.Set;

/**
 * @author Penflyz
 * @time 2021/8/26 11:14
 */
public class QQView {

    private String key = "";
    private String userID = "";
    private String pwd = "";
    private boolean loop = true;
    private MessageClientService messageClientService = new MessageClientService();

    private UserClientService userClientService = new UserClientService();
    public static void main(String[] args) {
        new QQView().viewMain();
    }

    public void viewMain() {


        while (loop) {
            System.out.println("===========欢迎登陆网络通信系统================");
            System.out.println("1.  用户登录");
            System.out.println("9.  退出登录");
            System.out.print("请输入你的选择：");
            key = Utility.readString(1);
            switch (key) {
                case "1":
                    System.out.print("请输入用户名：");
                    userID = Utility.readString(10);
                    System.out.print("请输入密码：");
                    pwd = Utility.readString(10);
                    if (userClientService.checkUser(userID, pwd)) {
                        System.out.println("==========" + userID + "登陆成功===========");
                        while (loop) {
                            System.out.println("1.  显示在线用户");
                            System.out.println("2.  群发消息");
                            System.out.println("3.  私发消息");
                            System.out.println("4.  发送文件");
                            System.out.println("9.  退出系统");
                            System.out.print("请输入你的选择：");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    userClientService.showOnlineFriend();
                                    break;
                                case "2":
                                    System.out.print("请输入你想说的话：");
                                    String contend1 = Utility.readString(50);

                                    Set<String> keySet = ManageClientConnectServerThread.getHm().keySet();
                                    for (String k : keySet) {
                                        ClientConnectSeverThread clientConnectSeverThread = ManageClientConnectServerThread.getHm().get(k);
                                        Socket socket = clientConnectSeverThread.getSocket();
                                        messageClientService.sendAllMessage(userID, contend1, socket);
                                    }
                                    break;
                                case "3":
                                    System.out.print("请选择想聊天的用户号（在线）：");
                                    String u = Utility.readString(5);
                                    System.out.print("请输入你想说的话：");
                                    String contend = Utility.readString(50);
                                    Socket socket = ManageClientConnectServerThread.getClientConnectServerThread(userID).getSocket();
                                    if (socket != null) {
                                        messageClientService.sendOneMessage(userID, u, contend,
                                                socket);
                                    }else {
                                        System.out.println("该用户不在线上" );
                                    }
                                    break;
                                case "4":
                                    System.out.print("请输入想发送文件的用户号（在线）：");
                                    String getterID = Utility.readString(5);
                                    System.out.print("请输入发送的文件完整路径：");
                                    String src = Utility.readString(50);
                                    Socket socket1 = ManageClientConnectServerThread.getClientConnectServerThread(userID).getSocket();
                                    new SendFileService().sendFileToOne(userID, getterID, socket1, src);

                                    break;
                                case "9":
                                    System.out.println("退出系统");
                                    userClientService.exitSys();
                                    loop = false;
                                    break;
                            }
                        }
                    } else {
                        System.out.println("你的用户名或密码错误");
                    }
                    break;
                case "9":
                    System.out.println("您已退出登录");

                    loop = false;
                    break;
            }
        }
    }
}