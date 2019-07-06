package BinaryTree;

import java.util.*;

public class BinaryTreeVerticalTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        nodeQueue.offer(root);
        indexQueue.offer(0);
        while (!nodeQueue.isEmpty()){
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = nodeQueue.poll();
                int index = indexQueue.poll();
                if (!map.containsKey(i)) map.put(index, new ArrayList<Integer>());
                map.get(index).add(node.val);
                if (node.left != null){
                    nodeQueue.add(node.left);
                    indexQueue.add(index - 1);
                }
                if (node.right != null){
                    nodeQueue.add(node.right);
                    indexQueue.add(index + 1);
                }
            }
        }

        for (int idx : map.keySet()){
            List<Integer> list = map.get(idx);
            res.add(list);
        }
        return res;
    }



}
