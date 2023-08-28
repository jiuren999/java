package old;

public class Framework {
    private Bottom bottom;
    public Framework(int size){
        this.bottom = new Bottom(size);
    }
    public void init(){
        System.out.println("执行了 Framework init 方法");
        bottom.init();
    }
}
