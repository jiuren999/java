
class SingletonLazy{
    private static SingletonLazy instance = null;

    public static SingletonLazy getInstance() {
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
    private SingletonLazy(){}
}

public class ThreadDemo3 {

    public static void main(String[] args) {

    }
}
