package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistFromAllBuildings {
    class Point{
        private int i;
        private int j;
        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] cost = new int[row][col];
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (grid[i][j] == 1){
                    BFS(grid, cost, i, j);
                    print(cost);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (grid[i][j] == 0 && cost[i][j] != 0){
                    res = Math.min(res, cost[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void BFS(int[][] grid, int[][] cost, int i, int j){
        int row = grid.length, col = grid[0].length;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(i, j));
        boolean[][] visited = new boolean[row][col];
        int dist = 1;
        visited[i][j] = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int k = 0; k < size; k++){
                Point curr = queue.poll();
                int x = curr.i, y = curr.j;
                for (int[] direct : directions){
                    int newX = x + direct[0], newY = y + direct[1];
                    if (newX >= 0 && newX < row && newY >= 0 && newY < col
                            && !visited[newX][newY] && grid[newX][newY] == 0){
                        visited[newX][newY] = true;
                        cost[newX][newY] += dist;
                        queue.offer(new Point(newX, newY));
                    }
                }
            }
            dist++;
        }

        for (int p = 0; p < row; p++){
            for (int q = 0; q < col; q++){
                if (!visited[p][q] && grid[p][q] == 0){
                    grid[p][q] = 2;
                }
            }
        }

    }

    private void print(int[][] cost){
        for (int i = 0; i < cost.length; i++){
            for (int j = 0; j < cost[0].length; j++){
                System.out.print(cost[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");

    }

    public static void main(String[] args){
        int[][] grid = {{0, 2, 1}, {1, 0, 2}, {0, 1, 0}};
        ShortestDistFromAllBuildings solution = new ShortestDistFromAllBuildings();
        int res = solution.shortestDistance(grid);
        System.out.println(res);
    }
}
