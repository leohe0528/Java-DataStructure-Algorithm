package BFS;

import java.util.*;

public class LetterCombination {
    Map<Character, List<Character>> map = new HashMap<>();
    {
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }
    public List<String> letterCombinations(String digits) {
        //cc
        List<String> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        for (int i = 0; i < digits.length(); i++){
            char num = digits.charAt(i);
            List<Character> listChar = map.get(num);
            while (!queue.isEmpty()){
                int size = queue.size();
                for (int j = 0; j < size; j++){
                    String curr = queue.poll();
                    for (char c : listChar){
                        String newStr = curr + c;
                        queue.add(newStr);
                    }
                }
            }
        }

        while (!queue.isEmpty()) res.add(queue.poll());
        return res;
    }

    public static void main(String[] args){
        String input = "23";
        List<String> res = new LetterCombination().letterCombinations(input);
    }
}
