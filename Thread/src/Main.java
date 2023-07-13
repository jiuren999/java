
class P{
    public static void hello(){
        System.out.println("11");
    }

    public P() {
        System.out.println("333");
    }
}
public class Main extends P{

    public static void main(String[] args) {
        P p =null;
        p.hello();
        P.hello();
        new Main();
        new P();
    }
}
