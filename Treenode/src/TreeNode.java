public class TreeNode {

    public int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode(){}

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root==null){
                return true;
            }
            return isSymmetricChild(root.left,root.right);
        }
        public boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree) {
            if (leftTree==null && rightTree != null || leftTree!=null && rightTree == null){
                return false;
            }
            if (leftTree==null && rightTree== null){
                return true;
            }
            if (leftTree.val!=rightTree.val){
                return false;
            }
            return isSymmetricChild(leftTree.left,rightTree.right)&&isSymmetricChild(leftTree.right,rightTree.left);
        }
    }
}
