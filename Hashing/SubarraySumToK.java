
package Hashing;

import java.util.HashMap;

public class SubarraySumToK {
    
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int prefixSum = 0;
        int count = 0;

        // Initialize the map with prefix sum 0 occurring once
        // We can understand by taking ex: as 1,2,3,4 and k = 6 
        // For 1+2+3 = 6 we need to increase count for perfect pair/subarray
        // If we don't have any prefixSumMap 0 then we can't increase 
        prefixSumMap.put(0, 1);

        for (int num : nums) {
            // Update the cumulative prefix sum
            prefixSum += num;

            // Check if there exists a prefix sum that would make the subarray sum to k
            if (prefixSumMap.containsKey(prefixSum - k)) {
                count += prefixSumMap.get(prefixSum - k);
            }

            // Add or update the prefix sum count in the map
            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        
        SubarraySumToK subarraySumToK = new SubarraySumToK();
        int ans = subarraySumToK.subarraySum(nums, k);

    
        System.out.println("Ans: " + ans);
    }
}