package BinaryTree;

public class IsBalance {

    private static int getHeight(TreeNode root){
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalance(TreeNode root){
        if (root == null) return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) return false;
        return isBalance(root.left) && isBalance(root.right);
    }
//    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        TreeNode result = null;
//        TreeNode prev = null;
//        inorder(root, p, result, prev);
//        return result;
//    }
//    private void inorder(TreeNode root, TreeNode p, TreeNode result, TreeNode prev){
//        if (root == null) return;
//        inorder(root.left, p, result, prev);
//        if (prev == p) {
//            result = root;
//        }
//        prev = root;
//        inorder(root.right, p, result, prev);
//    }
    TreeNode result = null, prev = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        helper(root, p);
        return result;
    }

    public void helper(TreeNode root, TreeNode p){
        if(root == null) return;
        helper(root.left, p);
        if(prev != null && prev.val == p.val) result = root;
        prev = root;
        helper(root.right, p);
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.left.left.left = new TreeNode(6);
        IsBalance successor = new IsBalance();
        TreeNode p = new TreeNode(1);
        TreeNode res = successor.inorderSuccessor(root, p);
//        IsBalance t = new IsBalance();
//        boolean isBalancedTree = t.isBalance(root);
//        System.out.println(isBalancedTree);
    }

}

