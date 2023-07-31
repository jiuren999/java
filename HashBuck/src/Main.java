

public class Main {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }


    public void convertNode(TreeNode pCur) {
        TreeNode prev = null;
        if (pCur == null){
            return ;
        }

        convertNode(pCur.left);
        pCur.left = prev;
        if (prev != null) {
            prev.right = pCur;
        }
        prev = pCur;
        convertNode(pCur.right);
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        convertNode(pRootOfTree);
        TreeNode head = pRootOfTree;
        while (head!=null && head.left != null){
            head = head.left;
        }
        return head;
    }
}
