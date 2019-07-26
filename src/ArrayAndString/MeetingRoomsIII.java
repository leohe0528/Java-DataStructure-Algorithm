package ArrayAndString;

import java.util.*;

public class MeetingRoomsIII {
    public List<int[]> meetingsWithoutConflict(int[][] intervals){
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        Map<int[], int[]> map = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        minHeap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            while (!minHeap.isEmpty() && curr[0] >= minHeap.peek()[1]){
                int[] remove = minHeap.poll();
                if (!map.containsKey(remove)) map.put(remove, new int[2]);
                map.put(remove, curr);
            }
            minHeap.offer(curr);
        }

        List<int[]> res = search(map);
        return res;
    }

    private List<int[]> search(Map<int[], int[]> map){
        List<int[]> res = new ArrayList<>();
        for (int[] key : map.keySet()){
            List<int[]> path = new ArrayList<>();
            dfs(path, key, map);
            if (path.size() >= res.size()) res = path;
        }
        return res;
    }

    private void dfs(List<int[]> path, int[] key, Map<int[], int[]> map){
        if (!map.containsKey(key)) {
            path.add(key);
            return;
        }
        path.add(key);
        dfs(path, map.get(key), map);
    }

    public static void main(String[] args){
        //int[][] intervals = {{2, 15}, {36, 45}, {9, 29}, {16, 23}, {4, 9}};
        //int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        int[][] intervals = {{13,15},{1,13}};
        List<int[]> res = new MeetingRoomsIII().meetingsWithoutConflict(intervals);
        for (int i = 0; i < res.size(); i++){
            System.out.println(res.get(i)[0] + " " + res.get(i)[1]);
        }
    }
}
