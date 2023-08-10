import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

public class UdpEchoServer {
    //首先先定义一个socket 对象
    //通过网络通信,必须要使用socket
    private DatagramSocket socket= null;

    //绑定一个端口不一定能成功
    //如果某个端口已经被别的进程占用了,此时这里的绑定操作就会出错
    //同一个主机上,一个端口,同一时刻,只能被一个进程绑定
    public UdpEchoServer(int port) throws SocketException {
        //构造socket的同时 ,指定要关联的端口
        socket = new DatagramSocket(port);
    }


    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true){
            //每次循环要做三件事情
            //1.读取请求并解析
            //构造空饭盒
            DatagramPacket requestPacket = new DatagramPacket(new byte[4999],4999);
            //食堂大妈给饭盒里盛饭{从网卡上}
            socket.receive(requestPacket);
            //为了方便处理这个请求,把数据包转换为String
            String request = new String(requestPacket.getData(), 0 ,requestPacket.getLength());
            //2.根据请求计算响应  此处省略这个步骤
            String response = process(request);
            //3.把响应结果写回客户端
            //根据response字符串 ,构造出一个DatagramPacket
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),response.getBytes().length
                    //requestPacket 是从客户端这里收来的 getSocketAddress就会得到客户端的IP和端口
            ,requestPacket.getSocketAddress());
            socket.send(responsePacket);
            System.out.printf("[%s:%d] req: %s, resp: %s\n",requestPacket.getAddress().toString(),
                    requestPacket.getPort() , request,response);
        }
    }


    //这个方法是希望根据请求计算响应
    //由于咱们写的是一个回显程序  请求是啥 响应就是啥
    //如果后续写个别的服务器 不再回显了  而是有具体的业务了,就可以修改 process方法
    //根据需要来重新构造响应
    //之所以单独列一个方法 就是想让同学们知道 ,这是一个服务器中的关键环节
    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer udpEchoServer = new UdpEchoServer(9090);
        udpEchoServer.start();
    }
}
