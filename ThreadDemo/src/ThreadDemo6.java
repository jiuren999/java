

//懒汉模型
class Singleton{
    volatile private static Singleton singleton = null;
     public Singleton getSingleton() {
         if (singleton==null){
             synchronized(Singleton.class){
                 if (singleton==null){
                     this.singleton = new Singleton();
                 }
             }
         }
         return singleton;
     }
    private Singleton(){}
}




public class ThreadDemo6 {

    public static void main(String[] args) {

    }
}
