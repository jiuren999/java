import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class IODemo7 {


    public static void main(String[] args) {

        try (OutputStream outputStream = new FileOutputStream("f:/bb.txt ")){
            outputStream.write(97);
            outputStream.write(98);
            outputStream.write(99);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Scanner scanner = new Scanner(System.in);
    int p = scanner.nextInt();
}
