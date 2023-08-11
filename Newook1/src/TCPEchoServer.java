import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TCPEchoServer {

    private ServerSocket serverSocket = null;
    Map<String,String> map = new HashMap<>();
    public TCPEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        map.put("cat","猫");
        map.put("dog","狗");
    }

    public void start() throws IOException {
        System.out.printf("服务器启动!\n");
        while (true){
            Socket clientSocket = serverSocket.accept();
            Thread thread = new Thread(()->{
                try {
                    processConnection(clientSocket);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }

    private void processConnection(Socket clientSocket) {
        System.out.printf("[%s:%d]客户端上线!\n",clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
        try(InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream()) {
            Scanner scanner = new Scanner(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream);
            while (true){
                if (!scanner.hasNext()){
                    System.out.printf("[%s,%d]客户端下线!\n",clientSocket.getInetAddress(),clientSocket.getPort());
                    break;
                }
                String request = scanner.next();
                String response = process(request);
                printWriter.println(response);
                printWriter.flush();
                System.out.printf("[%s:%d]  req:%s;  resp:%s\n",clientSocket.getInetAddress().toString(),
                        clientSocket.getPort(),request,response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String process(String request) {
        return map.getOrDefault(request,"该单词没有找到!");
      // return request;
    }

    public static void main(String[] args) throws IOException {
        TCPEchoServer tcpEchoServer = new TCPEchoServer(9090);
        tcpEchoServer.start();
    }
}
