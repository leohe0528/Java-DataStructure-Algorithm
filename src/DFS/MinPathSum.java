package DFS;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        //cc

        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        helper(grid, 0, 0, min);
        return min[0];
    }
    private int helper(int[][]grid, int i, int j, int[] min){
        int row = grid.length, col = grid[0].length;
        if (i >= row || j >= col) return 0;

        int right = helper(grid, i, j + 1, min);
        int bottom = helper(grid, i + 1, j, min);
        int currMin = grid[i][j];
        if (right == 0 || bottom == 0){
            currMin = (right == 0) ? currMin + bottom : currMin + right;
        }else{
            currMin += Math.min(bottom, right);
        }

        min[0] = Math.min(min[0], currMin);
        return currMin;
    }
    public static void main(String[] args){
        int[][] array = new int[3][];
        array[0] = new int[]{1, 3, 1};
        array[1] = new int[]{1, 5, 1};
        array[2] = new int[]{4, 2, 1};

        int res = new MinPathSum().minPathSum(array);
    }
}
