package Tree;

import java.util.*;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        //construct left stack and right stack
        Stack<TreeNode> leftStack = buildLeftStack(root);
        Stack<TreeNode> rightStack = buildRightStack(root.right);

        //maxHeap to sort result based on difference
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                double aDiff = Math.abs((double) a - target);
                double bDiff = Math.abs((double) b - target);
                if (bDiff - aDiff > 0) return 1;
                else if (bDiff - aDiff < 0) return -1;
                else return 0;
            }
        });

        res = findClosestKValues(leftStack, rightStack, maxHeap, k);
        return res;
    }

    private Stack<TreeNode> buildLeftStack(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while (curr != null){
            s.push(curr);
            curr = curr.left;
        }
        return s;
    }
    private Stack<TreeNode> buildRightStack(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while (curr != null){
            s.push(curr);
            curr = curr.right;
        }
        return s;
    }

    private List<Integer> findClosestKValues(Stack<TreeNode> leftStack, Stack<TreeNode> rightStack,
                                             PriorityQueue<Integer> maxHeap, int k){
        while (!leftStack.isEmpty()){
            TreeNode node = leftStack.pop();
            maxHeap.offer(node.val);
            if (maxHeap.size() > k) maxHeap.poll();
            TreeNode curr = node.right;
            while (curr != null){
                leftStack.push(curr);
                curr = curr.left;
            }
        }

        while (!rightStack.isEmpty()){
            TreeNode node = rightStack.pop();
            maxHeap.offer(node.val);
            TreeNode curr = node.left;
            if (maxHeap.size() > k) maxHeap.poll();
            while (curr != null){
                rightStack.push(curr);
                curr = curr.left;
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!maxHeap.isEmpty()){
            res.add(maxHeap.poll());
        }
        return res;
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        double target = 5.571429;
        int k = 2;
        List<Integer> res = new ClosestBinarySearchTreeValueII().closestKValues(root, target, k);
    }
}
