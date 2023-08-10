import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class UdpDictServer extends UdpEchoServer{


    private Map<String,String> dict = new HashMap<>();


    public UdpDictServer(int port) throws SocketException {
        super(port);

        dict.put("cat","猫");
        dict.put("dog","狗");
    }

    @Override
    public String process(String request){
        return dict.getOrDefault(request,"该单词没有查到");
    }

    public static void main(String[] args) throws IOException {
        UdpDictServer udpDictServer = new UdpDictServer(9090);
        udpDictServer.start();
    }
}
