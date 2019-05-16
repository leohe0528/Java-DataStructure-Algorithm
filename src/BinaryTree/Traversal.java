package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class TreeNode{
    int val;
    TreeNode right;
    TreeNode left;
    public TreeNode(int val){
        this.val = val;
        right = null;
        left = null;
    }
}

class Preorder{
    public List<Integer> preorderRecursion(TreeNode root){
        List<Integer> res = new ArrayList<>();
        preorderRecursion(root, res);
        return res;
    }
    private void preorderRecursion(TreeNode root, List<Integer> res){
        if (root == null) return;
        res.add(root.val);
        preorderRecursion(root.left, res);
        preorderRecursion(root.right, res);
    }

    public List<Integer> preorderIteration(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            if (root != null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                root = root.right;
            }
        }
        return res;
    }
}

class Inorder{
    public List<Integer> inorderRecursion(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        inorderRecursion(root, res);
        return res;
    }
    private void inorderRecursion(TreeNode root, List<Integer> res){
        if (root == null) return;
        inorderRecursion(root.left, res);
        res.add(root.val);
        inorderRecursion(root.right, res);
    }

    public List<Integer> inorderIteration(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            if (root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

}

class Postorder{
    public List<Integer> postorderRecursion(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        postorderRecursion(root, res);
        return res;
    }

    private void postorderRecursion(TreeNode root, List<Integer> res){
        if (root == null) return;
        postorderRecursion(root.left, res);
        postorderRecursion(root.right, res);
        res.add(root.val);
    }

    public List<Integer> postorderIteration(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            if (root != null){
                res.add(root.val);
                stack.push(root);
                root = root.right;
            }else{
                root = stack.pop();
                root = root.left;
            }
        }
        Collections.reverse(res);
        return res;
    }
}




public class Traversal {
    public static void print(List<Integer> nums){
        for (int i = 0; i < nums.size(); i++){
            System.out.print(nums.get(i) + " ");
        }
        System.out.println("");
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        //Preorder recursion and iteration
        List<Integer> preRec = new Preorder().preorderRecursion(root);
        print(preRec);
        List<Integer> preIte = new Preorder().preorderIteration(root);
        print(preIte);

        //Inorder recursion and iteration
        List<Integer> inRec = new Inorder().inorderRecursion(root);
        print(inRec);
        List<Integer> inIte = new Inorder().inorderIteration(root);
        print(inIte);

        //Postorder recursion and iteration
        List<Integer> posRec = new Postorder().postorderRecursion(root);
        print(posRec);
        List<Integer> posIte = new Postorder().postorderIteration(root);
        print(posIte);
    }
}
