package DFS;

import java.util.HashSet;
import java.util.Set;

public class numTilePossibilities {
    public int numTilePossibilities(String tiles) {
        if (tiles == null) return 0;
        Set<String> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < tiles.length(); i++){
            helper(tiles, i, new StringBuilder(), set);
        }
        return set.size();
    }

    private void helper(String tiles, int index, StringBuilder path, Set<String> set){
        String str = path.toString();
        if (set.contains(str)) return;
        if (index == tiles.length()) return;
        set.add(str);
        int len = path.length();
        for (int i = 0; i < tiles.length(); i++){
            path.append(tiles.charAt(i));
            helper(tiles, index + 1, path, set);
            path.setLength(len);
        }
    }
    public static void main(String[] args){
        String input = "AAB";
        int res = new numTilePossibilities().numTilePossibilities(input);
    }
}
