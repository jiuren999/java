package opera;

import book.Book;
import book.BookList;

import javax.jws.soap.SOAPBinding;
import java.util.Scanner;

public class ReturnOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("归还图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要归还的图书");
        String name = scanner.nextLine();

        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book book=bookList.getBook(i);
            if (book.getName().equals(name) && book.isBorrowed()){
                book.setBorrowed(false);
                System.out.println("归还成功");
                return;
            }
        }

    }
}
