package Old;

public class Tire {
    private int size = 15;
    public Tire(int size){
        this.size = size;
    }
    public void init(){
        System.out.println("执行了 Tire init，Size："+size);
    }
}
