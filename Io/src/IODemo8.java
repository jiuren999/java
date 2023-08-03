import java.io.*;
import java.util.Scanner;

public class IODemo8 {


    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要搜索的目录");
        //进入指定目录
        File file = new File(scanner.next());
        if (!file.isDirectory()){
            //说明不是目录
            System.out.println("输入有误,请重新输入");
            return;
        }

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("请输入你要查找的字符");
        String word = scanner1.next();

        scanDir(file , word);
    }

    private static void scanDir(File file, String word) throws FileNotFoundException {
        File[] files = file.listFiles();
        if (files == null){
            //说明根目录是空的  没必要递归了
            return;
        }
        for (File x:files) {
            System.out.println("现在进行到"+x.getAbsolutePath());
            if (x.isFile()){
                String content = readFile(x);
                if (content.contains(word)){
                    System.out.println(x.getAbsolutePath()+"包含要查找的关键字");
                }
            }else if (x.isDirectory()){
                scanDir(x,word);
            }else {
                continue;
            }
        }
    }

    private static String readFile(File x) throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        try (Reader reader = new FileReader(x)) {
            while (true){
                int c = reader.read();
                if (c == -1){
                    break;
                }
                stringBuilder.append((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
