package Hashing;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer, Integer> frequencyMap = new HashMap<>();
       
       // Create frequency map
       for (int num : nums) {
        frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    }

       // Create min heap to store k high frequency elements:
       PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(
        (a,b) -> a.getValue() - b.getValue()
       ); 

       for(Map.Entry<Integer,Integer> entry: frequencyMap.entrySet()) {
         minHeap.offer(entry);

         if(minHeap.size() > k) {
            minHeap.poll();
         }
       }


       int[] ans = new int[k];
       int index = 0;
       while (!minHeap.isEmpty()) {
        ans[index++] = minHeap.poll().getKey();
       }


       return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        // Expected output: [1, 2]
        TopKFrequentElements tkf = new TopKFrequentElements();
        int[] topKFrequents = tkf.topKFrequent(nums, k);

        for (int i : topKFrequents) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
