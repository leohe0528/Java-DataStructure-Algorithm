package DFS;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
public class HouseRobberIII {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        Map<TreeNode, Integer> map = new HashMap<>();
        return helper(root, map);
    }

    private int helper(TreeNode root, Map<TreeNode, Integer> map){
        if (map.containsKey(root)) return map.get(root);
        if (root == null) return 0;
        int val = 0;
        if (root.left != null){
            val += helper(root.left.left, map) + helper(root.left.right, map);
        }
        if (root.right != null){
            val += helper(root.right.left, map) + helper(root.right.right, map);
        }

        int max = Math.max(root.val + val, helper(root.left, map) + helper(root.right, map));
        map.put(root, max);
        return max;
    }

    public int robDP(TreeNode root){
        if (root == null) return 0;
        int[] max = helper(root);
        return Math.max(max[0], max[1]);
    }
    private int[] helper(TreeNode root){
        if (root == null) return new int[]{0, 0};

        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] max = new int[2];

        //root is not robbed
        max[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //root is robbed
        max[1] = root.val + left[0] + right[0];
        return max;
    }

}
