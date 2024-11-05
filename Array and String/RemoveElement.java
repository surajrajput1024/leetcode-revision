public class RemoveElement {

    public int removeElement1(int[] nums, int val) {
        int count = 0;

        // Loop through all elements and if the 
        // value is not same as the value 
        // then increase count else continue;
        for(int i = 0; i < nums.length; i++) {
          if(nums[i] != val) {
            count++;
          }
        }


        return count;
    }

    public int removeElement(int[] nums, int val) {
       int k = 0;

       for (int i = 0; i < nums.length; i++) {
        if(nums[i] != val) {
            nums[k] = nums[i];
            k++;
        }
       }

       return k;
    }


    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;

        RemoveElement re = new RemoveElement();
        int k = re.removeElement(nums, val);

        System.out.println("Size of the array after removing val " + val + " is: " + k);
    }
    
}
