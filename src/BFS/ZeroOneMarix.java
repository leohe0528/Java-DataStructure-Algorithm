package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMarix {
    class Point{
        private int i;
        private int j;
        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[][] updateMatrix(int[][] matrix) {
        //corner case
        if (matrix == null || matrix.length == 0 ||
                matrix[0] == null || matrix[0].length == 0) return matrix;

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] res = new int[row][col];
        int dist = 1;
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (matrix[i][j] == 0){
                    queue.offer(new Point(i, j));
                }
            }
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                Point curr = queue.poll();
                int x = curr.i, y = curr.j;
                for (int[] direct : directions){
                    int newX = x + direct[0], newY = y + direct[1];
                    if (newX >= 0 && newX < row && newY >= 0 && newY < col
                            && matrix[newX][newY] == 1 && res[newX][newY] == 0){
                        res[newX][newY] = dist;
                        queue.offer(new Point(newX, newY));
                    }
                }
            }
            dist++;
        }
        return res;
    }

    public static void main(String[] args){
        int[][] matrix = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] m ={{1,0,1,1,0,0,1,0,0,1},
                    {0,1,1,0,1,0,1,0,1,1},
                    {0,0,1,0,1,0,0,1,0,0},
                    {1,0,1,0,1,1,1,1,1,1},
                    {0,1,0,1,1,0,0,0,0,1},
                    {0,0,1,0,1,1,1,0,1,0},
                    {0,1,0,1,0,1,0,0,1,1},
                    {1,0,0,0,1,1,1,1,0,1},
                    {1,1,1,1,1,1,1,0,1,0},
                    {1,1,1,1,0,1,0,0,1,1}};
        ZeroOneMarix solution = new ZeroOneMarix();
        int[][] res = solution.updateMatrix(m);
        for (int i = 0; i < res.length; i++){
            for (int j = 0; j < res[0].length; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
