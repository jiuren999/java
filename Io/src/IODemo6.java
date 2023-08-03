import java.io.*;

public class IODemo6 {


    public static void main(String[] args) throws IOException {



        try (Reader reader = new FileReader("F:/bb.txt" )){
            while (true){
               int b = reader.read();
            if (b == -1){
                break;
            }
                System.out.printf("%x\n", b);
            }
        }
    }
}
