package ioc;

/**
 * 模拟 IoC
 */
public class Test {
    private Tire tire;
    private Bottom bottom;
    private Framework framework;
    private Car car;
    public Test(){
        this.tire = new Tire(12);
        this.bottom = new Bottom(this.tire);
        this.framework = new Framework(this.bottom );
        this.car = new Car(this.framework);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.car.init();
    }
}
