package IO;

import java.io.File;
import java.io.IOException;

public class IODemo2 {


    public static void main(String[] args) throws IOException {
        File file = new File("D:/手机照片备份/myphone_72089A8996EA/知.txt");

        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());

        file.createNewFile();
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        file.delete();
        System.out.println("执行删除之后");
        System.out.println(file.isFile());
    }
}
