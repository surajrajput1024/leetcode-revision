public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0; // Edge case for empty array

        int k = 1; // Start at 1, as the first element is always unique

        // Traverse through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) { // Found a unique element
                nums[k] = nums[i]; // Place unique element at index k
                k++; // Increment k for the next unique placement
            }
        }

        return k; // k represents the number of unique elements
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        RemoveDuplicatesFromSortedArray rd = new RemoveDuplicatesFromSortedArray();
        int ans = rd.removeDuplicates(nums);

        System.out.println("Required ans: " + ans);

        // Print the modified array with unique elements
        System.out.print("Modified array: ");
        for (int i = 0; i < ans; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
