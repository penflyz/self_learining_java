package com.penfly.server;

import com.penfly.common.Message;
import com.penfly.common.MessageType;
import com.penfly.common.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Penflyz
 * @time 2021/8/26 16:06
 */
public class QQServer {

    Message message = new Message();
    private static ConcurrentHashMap<String, User> validUsers = new ConcurrentHashMap<>();


    public static void main(String[] args) throws Exception {
        new QQServer();
    }

    static {
        validUsers.put("小祝", new User("小祝", "123"));
        validUsers.put("小符", new User("小符", "123"));
        validUsers.put("大准", new User("大准", "123"));
    }

    public boolean checkUser(String userID, String pwd) {
        User user1 = validUsers.get(userID);
        if (user1 != null && user1.getPwd().equals(pwd)) {
            System.out.println(userID + "密码正确,登录成功。");
            return true;
        } else {
            return false;
        }
    }

    public QQServer() throws Exception {

        ServerSocket serverSocket = new ServerSocket(9998);
        new Thread(new SeverSendNews()).start();

        while (true) {

            System.out.println("服务端在9998端口正在监听...");
            Socket socket = serverSocket.accept();
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            User user = (User) objectInputStream.readObject();


            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            //资料库的ID
            if (checkUser(user.getUserID(), user.getPwd())) {



                // 添加到数据库中了
                SeverConnectClientThread severConnectClientThread = new SeverConnectClientThread(user.getUserID(),socket);
                severConnectClientThread.start();

                ManageThread.addThread(user.getUserID(), severConnectClientThread);
                message.setMessageType(MessageType.MESSAGE_LOGIN_SUCCEED);
                objectOutputStream.writeObject(message);
            } else {
                System.out.println("用户 id=" + user.getUserID() + " pwd=" + user.getPwd() + " 验证失败");
                message.setMessageType(MessageType.MESSAGE_LOGIN_FAIL);
                objectOutputStream.writeObject(message);
                socket.close();
            }
        }
    }
}
