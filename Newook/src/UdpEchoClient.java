import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClient {
    private DatagramSocket socket = null;
    private String serverIP;
    private int serverPort;

    //客户端启动需要知道服务器在哪
    public UdpEchoClient(String serverIP ,int serverPort) throws SocketException {
        //对于客户端来说,不需要显示关联端口
        //不代表没有端口,而是系统自动分配了空闲的端口
        socket = new DatagramSocket();
        this.serverIP = serverIP;
        this.serverPort =serverPort;
    }

    public void start() throws IOException {
        //通过这个可以和服务器多次进行交互
        Scanner scanner = new Scanner(System.in);
        while (true){
            //1. 先从控制台读取一个字符串过来
            System.out.println("->");
            String request = scanner.next();
            //2. 把字符串构造成 UDP packet,并进行发送
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),request.getBytes().length,
            InetAddress.getByName(serverIP),serverPort);
            socket.send(requestPacket);
            //3. 客户端尝试读取服务器返回的响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4999],4999);
            socket.receive(responsePacket);
            //4. 把响应的数据转换成String显示出来
            String response = new String(responsePacket.getData(),0,responsePacket.getLength());
            System.out.printf("req: %s , resp: %s\n",request,response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient udpEchoClient = new UdpEchoClient("127.0.0.1",9090);
        udpEchoClient.start();
    }

}
