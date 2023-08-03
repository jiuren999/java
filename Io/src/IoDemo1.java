import java.io.File;
import java.io.IOException;

public class IoDemo1 {

    public static void main(String[] args) throws IOException {
        File file = new File("D:/手机照片备份/myphone_72089A8996EA/知乎");

        System.out.println(file.getParent());
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
    }
}
