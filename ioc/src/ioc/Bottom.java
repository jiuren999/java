package ioc;

public class Bottom {
    private Tire tire;
    public Bottom(Tire tire){
        this.tire = tire;
    }
    public void init(){
        System.out.println("Bottom init");
        tire.init();
    }
}
