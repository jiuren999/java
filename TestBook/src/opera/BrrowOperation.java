package opera;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class BrrowOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要借阅的图书");
        String name = scanner.nextLine();

        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book book=bookList.getBook(i);
            if (book.getName().equals(name) && !book.isBorrowed()){
                book.setBorrowed(true);
                System.out.println("借阅成功");
                return;
            }
        }
    }
}
