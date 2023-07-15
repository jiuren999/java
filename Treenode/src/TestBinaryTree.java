import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import sun.invoke.empty.Empty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TestBinaryTree {

    static class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;

        TreeNode(char val){
            this.val = val;
        }
    }
    public TreeNode root;

    public TreeNode createTree(){
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;

        this.root = A;
        return A;
    }

    //前序遍历
    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val+"");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        preOrder(root.left);
        System.out.println(root.val+"");
        preOrder(root.right);
    }

    public void posOrder(TreeNode root){
        if(root == null){
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.val+"");
    }


    // 获取树中节点的个数
    public int size(TreeNode root){
        if (root==null){
            return 0;
        }
        int leftSize = size(root.left);
        int rightSize = size(root.right);

        return leftSize+rightSize+1;
    }
    // 获取叶子节点的个数
    public int getLeafNodeCount(TreeNode root){
        if (root==null){
            return 0;
        }
        int leftSize = getLeafNodeCount(root.left);
        int rightSize = getLeafNodeCount(root.right);
        if (leftSize+rightSize==0){
            return 1;
        }
        return rightSize+leftSize;
    }
    // 子问题思路-求叶子结点个数
// 获取第K层节点的个数
    int getKLevelNodeCount(TreeNode root,int k){
        if (root==null){
            return 0;
        }
        if (k == 1){
            return 1;
        }
        int leftSize = getKLevelNodeCount(root.left,k-1);
        int rightSize = getKLevelNodeCount(root.right,k-1);

        return rightSize+leftSize;
    }
    // 获取二叉树的高度
    public int getHeight(TreeNode root){
        if (root==null){
            return 0;
        }
        int leftSize = getHeight(root.left);
        int rightSize = getHeight(root.right);

        return (leftSize>rightSize)?leftSize+1:rightSize+1;
    }
    // 检测值为value的元素是否存在
    TreeNode find(TreeNode root, int val){
        if (root == null){
            return null;
        }
        if (root.val == val){
            return root;
        }
        TreeNode left = find(root.left,val);
        if (left!=null){
            return left;
        }
        TreeNode right = find(root.right,val);
        if (right!=null){
            return right;
        }

        return null;
    }

    // 查询两个树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null&&q!=null || p!=null && q==null){
            return false;
        }
        if (p==null && q==null){
            return true;
        }
        if (p.val != q.val){
            return false;
        }
       return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);

    }
    //查询二叉树的子树
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (isSameTree(root,subRoot)){
            return true;
        }
        boolean left = isSubtree(root.left,subRoot);
        if (left){
            return true;
        }
        boolean right = isSubtree(root.right,subRoot);
        if (right){
            return true;
        }
        return false;
    }

    //反转二叉树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode ret = root.left;
        root.right = root.left;
        root.left = ret;

        invertTree(root.left);
        invertTree(root.right);
        return root;

    }
// 平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        if (Math.abs(leftH-rightH)<2
                &&isBalanced(root.left)
                &&isBalanced(root.right)
        ){
            return true;
        }
        return false;

    }

    //平衡二叉树做法2
    public boolean isBalanced2(TreeNode root) {
        if (getHeight(root)<0){
            return false;
        }
        return true;
    }

    public int getHeight2(TreeNode root){
        if (root==null){
            return 0;
        }
        int leftH = getHeight(root.left);
        if(leftH<0){
            return -1;
        }
        int rightH = getHeight(root.right);
        if(rightH<0){
            return -1;
        }
        if(Math.abs(leftH-rightH)<2){
            return Math.max(leftH,rightH)+1;
        }else{
            return -1;
        }

    }
    //层序遍历
    void levelOrder(TreeNode root){
        if (root==null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur.left != null){
                queue.offer(cur.left);
            }
            if (cur.right != null){
                queue.offer(cur.right);
            }
        }
    }
    class Solution {
        public List<List<Integer>> levelOrder1(TreeNode root) {
            List<List<Integer>> list = new LinkedList<>();
            if (root==null){
                return list;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> tmp = new ArrayList<>();
                while (size != 0) {
                    TreeNode cur = queue.poll();
                    // System.out.println(cur.val+" ");
                    tmp.add(cur.val);
                    size--;
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                list.add(tmp);
            }
            return list;
        }
    }

//    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(TreeNode root){
        if (root==null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur!=null){
                queue.offer(root.left);
                queue.offer(root.right);
            }else {
                break;
            }
        }
        while (!queue.isEmpty()){
            TreeNode tmp  = queue.poll();
            if (tmp!=null){
                return false;
            }
        }
        return true;
    }

}
