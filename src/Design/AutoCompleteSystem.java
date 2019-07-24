package Design;

import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.util.stream.Collectors;

/*
Example:
Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2])
The system have already tracked down the following sentences and their corresponding times:
"i love you" : 5 times
"island" : 3 times
"ironman" : 2 times
"i love leetcode" : 2 times
Now, the user begins another search:

Operation: input('i')
Output: ["i love you", "island","i love leetcode"]
Explanation:
There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.

Operation: input(' ')
Output: ["i love you","i love leetcode"]
Explanation:
There are only two sentences that have prefix "i ".

Operation: input('a')
Output: []
Explanation:
There are no sentences that have prefix "i a".

Operation: input('#')
Output: []
Explanation:
The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.

大概思路：因为根据一些prefix来搜索答案，所以很自然想到用trie
Step 1: 设计TrieNode: label, children, isWord, hashmap for top 3 string
Step 2: 设计Trie：有一个hashmap记录整个string出现的次数，一开始初始化，把input的cache存到map里面
Step 3: maintain一个path，a. 当输入字母时，返回top3， (str append这个字母)
                         b. 当输入#时，代表输入完整了整个str，
                            b.1 更新Trie的map，
                            b.2 更新完成path的每个字母的frequency; update top3
                            b.3 返回空
 */




public class AutoCompleteSystem {
    class TrieNode{
        private char label;
        private TrieNode[] children;
        private Map<String, Integer> top3;
        private boolean isLeaf;
        public TrieNode(char label){
            this.label = label;
            this.children = new TrieNode[27];
            this.top3 = new HashMap<>();
            this.isLeaf = false;
        }
    }

    class Trie{
        private TrieNode root;
        private Map<String, Integer> map;
        private StringBuilder path;
        private TrieNode curr;
        public Trie(String[] sentences, int[] times){
            this.root = new TrieNode('\0');
            this.map = new HashMap<>();
            for (int i = 0; i < sentences.length; i++){
                map.put(sentences[i], times[i]);
                insert(sentences[i], times[i]);
            }
            path = new StringBuilder();
            curr = root;
        }
    }

    private Trie trie;
    public AutoCompleteSystem(String[] sentences, int[] times) {
        trie = new Trie(sentences, times);
    }

    public List<String> input(char c) {
        if (c == '#'){
            String str = trie.path.toString();
            int freq = trie.map.getOrDefault(str, 0);
            trie.map.put(str, freq + 1);
            insert(str, freq + 1);
            trie.path.setLength(0);
            return new ArrayList<>();
        }
        //input non '#' character
        trie.path.append(c);
        if (trie.curr == null || trie.curr.children[getIdx(c)] == null){
            return new ArrayList<>();
        }
        trie.curr = trie.curr.children[getIdx(c)];
        return getTop3String(trie.curr.top3);
    }

    private void insert(String str, int count){
        TrieNode curr = trie.root;
        for (char c : str.toCharArray()){
            if (curr.children[getIdx(c)] == null){
                curr.children[getIdx(c)] = new TrieNode(c);
            }
            TrieNode next = curr.children[getIdx(c)];
            next.top3.put(str, count);
            List<Pair> top3 = getTop3Pair(next.top3);
            next.top3.clear();
            for (Pair p : top3){
                next.top3.put(p.str, p.count);
            }
            curr = next;
        }
        curr.isLeaf = true;

    }

    private int getIdx(char c){
        return (c >= 'a' && c <= 'z') ? (c - 'a') : 26;
    }

    private List<String> getTop3String(Map<String, Integer> countMap){
        return getTop3Pair(countMap).stream().map(p -> p.str).collect(Collectors.toList());
    }

    public class Pair{
        public String str;
        public int count;
        public Pair(String str, int count){
            this.str = str;
            this.count = count;
        }
    }

    private List<Pair> getTop3Pair(Map<String, Integer> countMap){
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) ->
                                                            (a.count == b.count
                                                                        ? a.str.compareTo(b.str)
                                                                    : b.count - a.count));
        for (Map.Entry<String, Integer> e : countMap.entrySet()) {
            maxHeap.offer(new Pair(e.getKey(), e.getValue()));
        }
        List<Pair> ret = new ArrayList<>();
        for (int i = 0; i < 3 && !maxHeap.isEmpty(); i++){
            ret.add(maxHeap.poll());
        }
        return ret;
    }
}
