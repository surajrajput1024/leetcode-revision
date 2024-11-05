package Hashing;

import java.util.HashMap;

public class MaxLengthSubarrayWithSumK {
    public int lenOfLongestSubarrBruteForce(int[] arr, int k) {
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if(sum == k && j - i + 1  > maxLength) {
                    maxLength = j - i + 1;
                } 
            }
        }

        return maxLength;
    }

    public int lenOfLongestSubarr(int[] arr, int k) {
        HashMap<Integer, Integer> prefixIndexMap = new HashMap<>();
        int maxLength = 0;
        int prefixSum = 0;

        // Traverse through the array
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // If prefix sum equals k, we found a subarray from 0 to i
            if (prefixSum == k) {
                maxLength = i + 1;
            }

            // If prefixSum - k is present in the map, it means there's a subarray summing to k
            if (prefixIndexMap.containsKey(prefixSum - k)) {
                maxLength = Math.max(maxLength, i - prefixIndexMap.get(prefixSum - k));
            }

            // Store the prefix sum index if it’s not already stored
            if (!prefixIndexMap.containsKey(prefixSum)) {
                prefixIndexMap.put(prefixSum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {1, -1, 5, -2, 3};
        int k = 3;

        MaxLengthSubarrayWithSumK maxLengthSubarrayWithSumK = new MaxLengthSubarrayWithSumK();
        int bruteForceAns = maxLengthSubarrayWithSumK.lenOfLongestSubarrBruteForce(arr, k);
        System.out.println("Brute force ans: " + bruteForceAns);

        int ans = maxLengthSubarrayWithSumK.lenOfLongestSubarr(arr, k);
        System.out.println("Optimised ans: " + ans);
    }
}
