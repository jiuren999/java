import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPEchoServer {

    private ServerSocket serverSocket = null;

    public TCPEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true){
            Socket clientSocket = serverSocket.accept();
            processConnection(clientSocket);
        }
    }
    //通过这个方法来处理一个链接
    //读取请求
    //根据请求计算响应
    //把响应返回给客户端
    private void processConnection(Socket clientSocket) throws IOException {
        System.out.printf("[%s:%d]客户端上线!\n",clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
        try(InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream()) {
            Scanner scanner = new Scanner(inputStream);
            //没有这个scanner和printwriter,完全可以 但是代价就是的一个字节一个字节扣 找到哪个是请求结束的标志
            //不是不能做 而是代码比较麻烦
            //为了简单把字节流包装成了更方便的字符流
            PrintWriter printWriter = new PrintWriter(outputStream);
            while (true){
                //1.读取请求
                if (!scanner.hasNext()){
                    //读取的流到结尾了(客户端关闭了)
                    System.out.printf("[%s:%d]客户端下线!\n",clientSocket.getInetAddress().toString(),
                            clientSocket.getPort());
                    break;
                }
                String request = scanner.next();
                //2.根据请求计算响应
                String response = process(request);
                //3.把响应写回客户端
                printWriter.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            clientSocket.close();
        }
    }
    private String process(String request) {
        return request;
    }
}
