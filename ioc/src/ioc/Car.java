package ioc;



public class Car {
    private Framework framework;
    public Car(Framework framework){
        this.framework = framework;
//        framework = new Framework();
    }
    public void init(){
        System.out.println("Car init");
        framework.init();
    }
}
