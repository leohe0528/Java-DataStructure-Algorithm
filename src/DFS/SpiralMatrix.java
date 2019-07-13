package DFS;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return res;
        helper(matrix, 0, matrix.length, matrix[0].length, res);
        return res;
    }

    private void helper(int[][] matrix, int offset, int rowSize, int colSize, List<Integer> res){
        //base case
        if (rowSize == 0 || colSize == 0) return;
        if (rowSize == 1 || colSize == 1){
            if (rowSize == 1){
                for (int j = 0; j < colSize; j++){
                    res.add(matrix[offset][offset + j]);
                }
            }else{
                for (int i = 0; i < rowSize; i++){
                    res.add(matrix[offset + i][offset]);
                }
            }
            return;
        }


        //add top
        for (int j = 0; j < colSize - 1; j++){
            res.add(matrix[offset][offset + j]);
        }

        //add right
        for (int i = 0; i < rowSize - 1; i++){
            res.add(matrix[offset + i][offset + colSize - 1]);
        }

        //add bot
        for (int j = 0; j < colSize - 1; j++){
            res.add(matrix[offset + rowSize - 1][offset + colSize - 1 - j]);
        }

        for (int i = 0; i < rowSize - 1; i++){
            res.add(matrix[offset + rowSize - 1 - i][offset]);
        }

        helper(matrix, offset + 1, rowSize - 2, colSize - 2, res);
    }

    public static void main(String[] args){
        int[][] nums = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> res = new SpiralMatrix().spiralOrder(nums);
    }
}
