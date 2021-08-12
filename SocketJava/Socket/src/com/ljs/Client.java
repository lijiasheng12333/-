package com.ljs;

import java.io.IOException;
import java.net.Socket;

public class Client {
    //这个端口号表示目标端口，即服务端端口
    //客户端端口由操作系统帮我们分配
    public static int port = 1050;
    public static String host = "localhost"; //ip
    public static void main(String[] args) throws IOException, InterruptedException {
        //Socket[] sockets = new Socket[10];
        //创建套接字
        Socket socket = new Socket(host, port);
        Thread.sleep(10000);
        socket.close();
    }
}
