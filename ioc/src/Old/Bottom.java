package Old;

public class Bottom {
    private Tire tire;
    public Bottom(int size){
        this.tire = new Tire(size);
    }

    public void init(){
        System.out.println("执行了 Bottom init 方法");
        tire.init();
    }
}
