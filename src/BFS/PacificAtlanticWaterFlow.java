package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {
    class Point{
        private int i;
        private int j;
        public Point (int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();

        if (matrix == null || matrix.length == 0 ||
                matrix[0] == null || matrix[0].length == 0) return res;
        int row = matrix.length, col = matrix[0].length;
        boolean[][] pacificFlow = new boolean[row][col];
        boolean[][] atlanticFlow = new boolean[row][col];
        Queue<Point> queue = new LinkedList<>();
        //Process flow to Pacific
        for (int i = 0; i < row; i++){
            queue.offer(new Point(i, 0));
            pacificFlow[i][0] = true;
        }
        for (int j = 1 ; j < col; j++){
            queue.offer(new Point(0, j));
            pacificFlow[0][j] = true;
        }
        BFS(matrix, queue, pacificFlow, atlanticFlow, res);

        for (int i = 0; i < row; i++){
            queue.offer(new Point(i, col - 1));
            atlanticFlow[i][col - 1] = true;
        }
        for (int j = 0; j < col - 1; j++){
            queue.offer(new Point(row - 1, j));
            atlanticFlow[row - 1][j] = true;
        }
        BFS(matrix, queue, atlanticFlow, pacificFlow, res);
        return res;
    }

    private void BFS(int[][] matrix, Queue<Point> queue,
                     boolean[][] selfFlow,  boolean[][] otherFlow,
                     List<int[]> res){

        int row = matrix.length, col = matrix[0].length;
        while (!queue.isEmpty()){
            Point curr = queue.poll();
            int x = curr.i, y = curr.j;

            //check whether there is overlap
            if (otherFlow[x][y]) {
                res.add(new int[]{x, y});
                // continue;
            }

            for (int[] direct : directions){
                int newX = x + direct[0], newY = y + direct[1];
                if (newX >= 0 && newX < row && newY >= 0 && newY < col
                        && !selfFlow[newX][newY] && matrix[x][y] <= matrix[newX][newY]){
                    queue.offer(new Point(newX, newY));
                    selfFlow[newX][newY] = true;
                }
            }
        }
    }

}
