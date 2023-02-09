package opera;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class AddOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("添加图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书名");
        String name = scanner.nextLine();

        System.out.println("请输入作者");
        String author = scanner.nextLine();

        System.out.println("请输入类型");
        String type = scanner.nextLine();

        System.out.println("请输入价格");
        int price = scanner.nextInt();

        Book book = new Book(name,author,price,type);

        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book tmp = bookList.getBook(i);
            if (tmp.getName().equals(name)) {
                System.out.println("已经存在这本书了，不能重复添加");
                return;
            }

        }
        bookList.setBook(book);
        bookList.setUsedSize(currentSize+1);
    }
}
