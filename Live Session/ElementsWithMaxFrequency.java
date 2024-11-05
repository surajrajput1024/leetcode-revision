
import java.util.HashMap;
import java.util.Map;

public class ElementsWithMaxFrequency {
    
        public int maxFrequencyElements(int[] nums) {
            HashMap<Integer,Integer> frequencyMap = new HashMap<>();
            
            // Populate the frequency map:
            for (int num : nums) {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }

            // Find the max frequency
            int maxFrequency = 0;
            for (int frequency : frequencyMap.values()) {
                if (frequency > maxFrequency) {
                    maxFrequency = frequency;
                }
            }

            // Get all the elements with max frequency:
            int count = 0;
           for (Map.Entry<Integer,Integer> entry : frequencyMap.entrySet()) {
            if(entry.getValue() == maxFrequency) {
                count += entry.getValue();
            }
           }

            
            return count;
        }
    
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,4};

        ElementsWithMaxFrequency ewmf = new ElementsWithMaxFrequency();
        int ans = ewmf.maxFrequencyElements(nums);

        System.out.println("Ans: "+ans);
    }
}