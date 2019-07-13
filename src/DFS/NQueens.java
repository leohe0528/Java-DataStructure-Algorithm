package DFS;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) return res;
        List<StringBuilder> board = constructBoard(n);
        helper(board, 0, n, res);
        return res;
    }

    private void helper(List<StringBuilder> board, int row, int n, List<List<String>> res){
        if (row == n){
            List<String> newBoard = convertToNewBoard(board);
            res.add(newBoard);
            return;
        }
        for (int i = 0; i < n; i++){
            if (isValid(board, row, i, n)){
                board.get(row).setCharAt(i, 'Q');
                helper(board, row + 1, n, res);
                board.get(row).setCharAt(i, '.');
            }
        }
    }

    private List<StringBuilder> constructBoard(int n){
        List<StringBuilder> board = new ArrayList<>();
        for (int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++){
                sb.append('.');
            }
            board.add(sb);
        }
        return board;
    }

    private List<String> convertToNewBoard(List<StringBuilder> board){
        List<String> newBoard = new ArrayList<>();
        for (int i = 0; i < board.size(); i++){
            String str = board.get(i).toString();
            newBoard.add(str);
        }
        return newBoard;
    }

    private boolean isValid(List<StringBuilder> board, int r, int c, int n){
        //check Row
        boolean checked = true;
        for (int i = 0; i < r; i++){
            if (board.get(i).charAt(c) == 'Q') checked = false;
        }

        //check bot right to top left
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--){
            if (board.get(i).charAt(j) == 'Q') checked = false;
        }

        //check bot left to top right
        for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++){
            if (board.get(i).charAt(j) == 'Q') checked = false;
        }

        return checked;
    }

    public static void main(String[] args){
        List<List<String>> res = new NQueens().solveNQueens(5);

    }
}
