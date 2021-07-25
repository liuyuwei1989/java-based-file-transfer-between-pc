package cn.liuyuwei1989.filetransfertool.front.port;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

@Slf4j
public class NetUtils {

    /**
     * 测试本机端口是否被使用
     * @param port
     * @return
     */
    public static boolean isLocalPortUsing(int port){
        boolean flag = true;
        try {
            //如果该端口还在使用则返回true,否则返回false,127.0.0.1代表本机
            flag = isPortUsing("127.0.0.1", port);
        } catch (Exception e) {
        }
        return flag;
    }
    /***
     * 测试主机Host的port端口是否被使用
     * @param host
     * @param port
     * @throws UnknownHostException
     */
    public static boolean isPortUsing(String host,int port) {
        boolean flag = false;
        try {
            InetAddress Address = InetAddress.getByName(host);
            Socket socket = new Socket(Address,port); //建立一个Socket连接
            flag = true;
        } catch (IOException e) {
            //log.info(e.getMessage(),e);
        }
        return flag;
    }
}
