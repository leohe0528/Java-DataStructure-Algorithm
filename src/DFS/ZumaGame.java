package DFS;

import java.util.HashMap;
import java.util.Map;

public class ZumaGame {
    private int minBalls = Integer.MAX_VALUE;
    public int findMinStep(String board, String hand) {
        if (board == null) return 0;
        Map<Character, Integer> map = new HashMap<>();
        for (Character ball : hand.toCharArray()){
            map.put(ball, map.getOrDefault(ball, 0) + 1);
        }
        helper(board, hand, 0, map);
        return minBalls == Integer.MAX_VALUE ? -1 : minBalls;
    }
    private void helper(String board, String hand, int count, Map<Character, Integer> map){
        if (board.length() == 0){
            minBalls = Math.min(minBalls, count);
            return;
        }
        if (map.size() == 0) return;

        for (int i = 0; i < board.length(); i++){
            char ballOnBoard = board.charAt(i);
            Integer numBallToRemove = map.get(ballOnBoard);

            if (numBallToRemove == null) continue;

            if (numBallToRemove >= 2){ //use two balls
                String newBoard = generateBoard(board, i - 1, i + 1);
                if (numBallToRemove - 2 == 0) map.remove(ballOnBoard);
                else map.put(ballOnBoard, numBallToRemove - 2);
                helper(newBoard, hand, count + 2, map);
                map.put(ballOnBoard, numBallToRemove);
            }
            if (i + 1 < board.length() && ballOnBoard == board.charAt(i + 1)){ //use one ball
                String newBoard = generateBoard(board, i - 1, i + 2);
                if (numBallToRemove - 1 == 0) map.remove(ballOnBoard);
                else map.put(ballOnBoard, numBallToRemove - 1);
                helper(newBoard, hand, count + 1, map);
                map.put(ballOnBoard, numBallToRemove);
            }

        }
    }

    private String generateBoard(String board, int left, int right){
        while (left >= 0 && right < board.length()){
            char c = board.charAt(left);
            int cnt = 0;
            int i = left;
            while (i >= 0 && c == board.charAt(i)){
                i--;
                cnt++;
            }
            int j = right;
            while (j < board.length() && c == board.charAt(j)){
                j++;
                cnt++;
            }
            if (cnt < 3) break;
            else{
                left = i;
                right = j;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= left; i++){
            sb.append(board.charAt(i));
        }
        for (int j = right; j < board.length(); j++){
            sb.append(board.charAt(j));
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String a = "WWRRBBWW";
        String b = "WRBRW";
        int res = new ZumaGame().findMinStep(a, b);
    }
}
