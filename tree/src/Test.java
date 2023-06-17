public class Test {

    public static void main(String[] args) throws NullTreeNodeException{
        TestBinaryTree testBinaryTree = new TestBinaryTree();
         TestBinaryTree.TreeNode ret = testBinaryTree.createTree();
         TestBinaryTree.TreeNode ret1 = testBinaryTree.find(ret,'B');
        System.out.println(ret1.val);
    }
}
