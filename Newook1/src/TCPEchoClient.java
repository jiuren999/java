import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPEchoClient {


    Socket socket = null;

    public TCPEchoClient (String serverIP,int serverPort) throws IOException {
        socket = new Socket(serverIP,serverPort);
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        try(InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()) {

            PrintWriter printWriter = new PrintWriter(outputStream);
            Scanner scannerFromSocket = new Scanner(inputStream);
            while (true){
                System.out.printf("->\n");
                String request = scanner.next();
                printWriter.println(request);
                printWriter.flush();

                String response = scannerFromSocket.next();

                System.out.printf("res:%s ; resp:%s\n",request,response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } ;
    }

    public static void main(String[] args) throws IOException {
        TCPEchoClient tcpEchoClient = new TCPEchoClient("127.0.0.1",9090);
        tcpEchoClient.start();
    }
}
