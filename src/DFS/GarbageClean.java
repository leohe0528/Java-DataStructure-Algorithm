package DFS;

import java.util.ArrayList;
import java.util.List;

public class GarbageClean {
    public int efficientJanitor(List<Float> weight){


        return helper(weight, 0, 3.0f);
    }
    private int helper(List<Float> weight, int index, float leftOverWeight){
        if (weight.size() == 1) return 1;
        if (leftOverWeight <= 0.0f) return 0;

        int count = Integer.MAX_VALUE;
        for (int j = index; j < weight.size(); j++){
            int removeInd = j;
            float removeVal = weight.get(removeInd);
            leftOverWeight = leftOverWeight - removeVal;

            if (leftOverWeight >= 0.0){
                weight.remove(weight.get(removeInd));
                count = 1 + Math.min(count, helper(weight, j, leftOverWeight));
                leftOverWeight = leftOverWeight + removeVal;
                weight.add(removeInd,removeVal);
            }else{

            }
        }
        return count;
    }

    public static void main(String[] args){
        List<Float> weight = new ArrayList<>();
        weight.add(1.50f);

        int res = new GarbageClean().efficientJanitor(weight);
        System.out.println(res);
    }
}
