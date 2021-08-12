package com.ljs;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: ljs
 */
public class Server {
    private int port = 1050;  //模拟端口号
    private ServerSocket serverSocket;


    public Server() throws IOException {
        //backlog: 全连接队列  不填写bindAddr参数默认绑定主机的ip地址
        //此时监听1050这个端口
        serverSocket = new ServerSocket(port);
        System.out.println("服务端已启动!");
    }

    public void init() {
        while (true) {
            Socket socket = null;
            try {
                //没有连接时会阻塞，当有连接请求时返回一个socket
                socket = serverSocket.accept();


                System.out.println("新连接请求, " + socket.getInetAddress() + ":" + socket.getPort());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                        System.out.println("服务端连接关闭");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = new Server();
        server.init();
    }
}
