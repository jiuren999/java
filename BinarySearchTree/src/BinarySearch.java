public class BinarySearch {

    static class TreeNode{

        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }
    TreeNode root = null;

    public TreeNode find(int val){
        TreeNode cur = root;
        while (cur != null){
            if (cur.val < val){
                return cur.right;
            }else if (cur.val > val){
                return cur.left;
            }else{
                return cur;
            }
        }
        return null;
    }

    public void insert(int val){
        if (root == null){
            root = new TreeNode(val);
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null){
            if (cur.val > val){
                parent = cur;
                cur = cur.left;
            }else if (cur.val < val){
                parent = cur;
                cur = cur.right;
            }else {
                break;
            }
        }
        TreeNode tmp = new TreeNode(val);
        if (parent.val > val){
            parent.left = tmp;
        }
        if (parent.val < val){
            parent.right = tmp;
        }
    }

    private void remove(int val){
        TreeNode cur = root;
        TreeNode parent = null;

        while (cur != null){
            if (cur.val == val){
                removeNode(parent,cur);
                return;
            }else if (cur.val < val){
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }

    }
    private void removeNode(TreeNode parent,TreeNode cur){

        if (cur.left == null){
            if (cur==root){
                root = cur.right;
            }else if (parent.left == cur){
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }
        }else if (cur.right == null){
            if (cur == root){
                root = cur.left;
            }else if (parent.left == cur){
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else {
            TreeNode target = cur.right;
            TreeNode targetParent = cur;

            while (target.left != null){
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;
            if (target == targetParent.left) {
                targetParent.left = target.right;
            }else {
                targetParent.right = target.right;
            }
        }
    }
}
