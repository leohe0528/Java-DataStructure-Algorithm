package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    class Point{
        private int i;
        private int j;
        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void wallsAndGates(int[][] rooms){
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) return;

        int row = rooms.length;
        int col = rooms[0].length;
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (rooms[i][j] == 0){
                    queue.add(new Point(i, j));
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
                    if (newX < 0 || newX >= row || newY < 0 || newY >= col) continue;
                    if (rooms[newX][newY] != Integer.MAX_VALUE || rooms[x][y] == -1) continue;
                    rooms[newX][newY] = rooms[x][y] + 1;
                    queue.offer(new Point(newX, newY));
                }
            }
        }
    }

    public static void main(String[] args){
        int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        WallsAndGates solution = new WallsAndGates();
        solution.wallsAndGates(rooms);
        for (int i = 0; i < rooms.length; i++){
            for (int j = 0; j < rooms[0].length; j++){
                System.out.print(rooms[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
