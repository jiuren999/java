package Old;

public class car {
    private Framework framework;

    public car(int size){
        this.framework = new Framework(size);
    }

    public void init(){
        System.out.println("执行了car init方法");
        framework.init;
    }
}
