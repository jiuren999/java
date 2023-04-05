public class Test {

    public static void main(String[] args) {

        Mysinglist mysinglist = new Mysinglist();

        mysinglist.creatLink();
        mysinglist.display();
        mysinglist.addIndex(3,45);
        mysinglist.display();
        System.out.println("============");
        mysinglist.removeAllKey(45);
        mysinglist.display();
    }
}
