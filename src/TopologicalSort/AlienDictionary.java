package TopologicalSort;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        if (words.length == 1) return words[0];

        //construct graph
        List<V> vs = new ArrayList<>();
        V[] graph = new V[26];
        boolean check = buildGraph(vs, graph, words);
        //if fail, then return ""
        if (!check) return "";

        //check if there is cycle
        char[] res = new char[vs.size()];
        currPos = res.length - 1;
        for (V v : vs){
            if (hasCycle(v, res)) return "";
        }

        //return ans
        return new String(res);
    }

    private int currPos = 0;
    //construct vertex
    private enum Status{
        INITIAL, PROCESSING, DONE;
    }

    private class V{
        private char label;
        private Status status;
        private List<V> neighbors;
        public V(char label){
            this.label = label;
            this.status = Status.INITIAL;
            this.neighbors = new ArrayList<V>();
        }
    }

    private boolean hasCycle(V v, char[] res){
        if (v.status == Status.DONE) return false;
        if (v.status == Status.PROCESSING) return true;

        v.status = Status.PROCESSING;
        for (V next : v.neighbors){
            if (hasCycle(next, res)) return true;
        }
        v.status = Status.DONE;
        res[currPos--] = v.label;
        return false;
    }

    private boolean buildGraph(List<V> vs, V[] graph, String[] words){
        String prev = words[0];
        for (int i = 1; i < words.length; i++){
            int idx1 = 0, idx2 = 0;
            String curr = words[i];

            while (idx1 < prev.length() && idx2 < curr.length()){

                char ch1 = prev.charAt(idx1++), ch2 = curr.charAt(idx2++);

                if (graph[ch1 - 'a'] == null){
                    graph[ch1 - 'a'] = new V(ch1);
                    vs.add(graph[ch1 - 'a']);
                }
                if (graph[ch2 - 'a'] == null){
                    graph[ch2 - 'a'] = new V(ch2);
                    vs.add(graph[ch2 - 'a']);
                }
                if (ch1 != ch2){
                    graph[ch1 - 'a'].neighbors.add(graph[ch2 - 'a']);
                    break;
                }
            }

            while (idx1 < prev.length()){
                char c = prev.charAt(idx1++);
                if (graph[c - 'a'] == null){
                    graph[c - 'a'] = new V(c);
                    vs.add(graph[c - 'a']);
                }
            }
            while (idx2 < curr.length()){
                char c = curr.charAt(idx2++);
                if (graph[c - 'a'] == null){
                    graph[c - 'a'] = new V(c);
                    vs.add(graph[c - 'a']);
                }

            }
            prev = curr;
        }
        return true;
    }

    public static void main(String[] args){
        String[] input = {  "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"};
        String res = new AlienDictionary().alienOrder(input);
    }
}
