package BFS;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CheapestFlightWithKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {


        //Map: src : {dst, price}
        Map<Integer, Map<Integer, Integer>> costs = new HashMap<>();
        for (int[] flight : flights){
            if (!costs.containsKey(flight[0])){
                costs.put(flight[0], new HashMap<>());
            }
            costs.get(flight[0]).put(flight[1], flight[2]);
        }

        //minHeap: price, city, stop
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        minHeap.offer(new int[]{0, src, K + 1});
        while (!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int price = curr[0];
            int city = curr[1];
            int stop = curr[2];
            if (city == dst) return price;
            if (stop > 0){
                Map<Integer, Integer> adj = costs.getOrDefault(city, new HashMap<>());
                for (int a : adj.keySet()){
                    System.out.println(a + " " + adj.get(a));
                    minHeap.offer(new int[] {price + adj.get(a), a, stop - 1});
                }
            }
        }
        return -1;
    }
}
