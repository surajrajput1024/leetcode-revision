package Hashing;

import java.util.HashMap;

public class MaxDistanceBetweenSameElemements {
 
    public int maxDistance(int[] arr) {
        HashMap<Integer,Integer> firstOccurHashMap = new HashMap<>();
        int maxDistance = 0;

        for (int i = 0; i < arr.length; i++) {
            // if the firstOccurance don't contain number then 
            // Just put  first occurance:
            if(!firstOccurHashMap.containsKey(arr[i])) {
                firstOccurHashMap.put(arr[i], i);
            } else {
                // Get first occurance and distance between them:
                int firstOccuranceIndex = firstOccurHashMap.get(arr[i]);
                int distance = i - firstOccuranceIndex;

                if(distance > maxDistance) {
                    maxDistance =  distance;
                }
                
            }
        }

        return maxDistance;
    }
    
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};
        
        MaxDistanceBetweenSameElemements mdbse = new MaxDistanceBetweenSameElemements();
        int ans = mdbse.maxDistance(arr);

        System.out.println("Ans: " + ans);
    }
    
}
