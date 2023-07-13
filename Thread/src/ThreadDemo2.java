
class Singleton{
    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    private Singleton(){}
}

public class ThreadDemo2 {

    public static void main(String[] args) {
//        Singleton n1 = new Singleton();
    }
}
