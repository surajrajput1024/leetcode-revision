package Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class KDiffPairs {
    public int findPairsBruteForce(int[] nums, int k) {
        int ans = 0;
        HashSet<String> uniquePairs = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    int smaller = Math.min(nums[i], nums[j]);
                    int larger = Math.max(nums[i], nums[j]);
                    
                    // Create a string representation of the pair
                    String pair = smaller + "," + larger;
                    
                    // Only add to answer if the pair hasn't been counted before
                    if (!uniquePairs.contains(pair)) {
                        uniquePairs.add(pair);
                        ans++;
                    }
                }
            }
        }

        return ans;
    }


    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0; // No pairs possible for negative k

        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        
        // Step 1: Populate the frequency map
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Find pairs with difference k
        for (int num : map.keySet()) {
            if (k == 0) {
                // Case when k is 0: Count elements that appear at least twice
                if (map.get(num) >= 2) {
                    ans++;
                }
            } else {
                // Case when k > 0: Check if num + k exists
                if (map.containsKey(num + k)) {
                    ans++;
                }
            }
        }
        
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,4,4,3,3,0,9,2,3}; // 1, 2-1 = 1 , 
        int k = 3;

        KDiffPairs kDiffPairs = new KDiffPairs();
        int ans = kDiffPairs.findPairs(nums, k);
        
        System.out.println("Ans: " + ans);
    }
    
}
