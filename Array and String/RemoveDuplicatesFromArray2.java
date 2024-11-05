public class RemoveDuplicatesFromArray2 {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length; // If length is 2 or less, no modification needed
        }

        int k = 2; // Start from the third position

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) { // Check if current element can be added
                nums[k] = nums[i]; // Place it at position k
                k++; // Move k to the next position
            }
        }

        return k; // k represents the number of elements with duplicates allowed twice
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        RemoveDuplicatesFromArray2 rd = new RemoveDuplicatesFromArray2();
        int ans = rd.removeDuplicates(nums);

        System.out.println("Required ans: " + ans);

        // Print the modified array with duplicates allowed twice
        System.out.print("Modified array: ");
        for (int i = 0; i < ans; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
