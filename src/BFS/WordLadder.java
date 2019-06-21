package BFS;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //corner case
        if (beginWord == null || endWord == null || wordList == null) return -1;

        //construct word dictionary
        Set<String> wordDict = new HashSet<>();
        for (String word : wordList){
            wordDict.add(word);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int minLen = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                String curr = queue.poll();

                //change characters
                char[] array = curr.toCharArray();
                for (int j = 0; j < array.length; j++){
                    char temp = array[j];
                    for (char c = 'a'; c <= 'z'; c++){
                        array[j] = c;
                        String newWord = String.valueOf(array);
                        if (c != temp && wordDict.contains(newWord)){
                            if (newWord.equals(endWord)) return minLen + 1;
                            queue.offer(newWord);
                            wordDict.remove(newWord);
                        }
                    }
                    array[j] = temp;
                }
            }
            minLen++;
        }
        return 0;
    }
}
