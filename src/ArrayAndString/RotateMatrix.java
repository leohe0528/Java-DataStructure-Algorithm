package ArrayAndString;

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) return;
        int size = matrix.length;
        int n = matrix.length;
        helper(matrix, 0, size);
    }
    private void helper(int[][] matrix, int offset, int size){
        if (size == 0 || size == 1) return;

        for (int i = 0; i < size; i++){
            int temp = matrix[offset + i][offset];
            matrix[offset + i][offset] = matrix[offset + size - 1][offset + i];
            matrix[offset + size - 1][offset + i] = matrix[offset + size - 1 - i][offset + size - 1];
            matrix[offset + size - 1 - i][offset + size - 1] = matrix[offset][offset + size - 1 - i];
            matrix[offset][offset + size - 1 - i] = temp;
        }
        helper(matrix, offset + 1, size - 2);
    }
    public static void main(String[] args){
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        new RotateMatrix().rotate(matrix);
    }
}
