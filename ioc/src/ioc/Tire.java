package ioc;

public class Tire {
    private int size = 15;
    public Tire(int size){
        this.size = size;
    }
    public void init(){
        System.out.println("Tire init, Size:"+size);
    }
}
