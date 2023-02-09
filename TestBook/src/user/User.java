package user;

import book.BookList;
import opera.IOperation;

public abstract class User {
    protected String name;

    protected IOperation[] iOperation;

    public User(String name) {
        this.name = name;
    }

    public abstract int menu() ;

    public void doWork(int choice, BookList bookList){
        this.iOperation[choice].work(bookList);
    }

}
