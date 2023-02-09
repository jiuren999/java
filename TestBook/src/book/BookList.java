package book;

public class BookList {

    private static final int DEFAULT_SIZE =10;


    private Book[] books = new Book[DEFAULT_SIZE];

    public BookList(){
        books[0]= new Book("三国演义","罗贯中",89,"小说");
        books[1]= new Book("西游记","吴承恩",78,"小说");
        books[2]= new Book("红楼梦","曹雪芹",89,"小说");
        this.usedSize=3;
    }

    public Book getBook(int pos) {

        return this.books[pos];
    }
    public void setBook(Book book){

        this.books[usedSize]=book;
    }

    public void setBook(int pos,Book book){
        this.books[pos]=book;
    }

    private int usedSize;// books数组中有多少本书

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }
}
