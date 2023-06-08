public class EmptyException extends RuntimeException {
    public EmptyException() {
    }

    public EmptyException(String message) {
        super(message);
    }

    public static void main1(String[] args) {
        test test1 = new test();
        String[] tokens ={"4","13","5","/","+"};
        int a = test1.evalRPN(tokens);
        System.out.println(a);
    }
}
