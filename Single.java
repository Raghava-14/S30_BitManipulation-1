//Time = O(n)
//Space = O(1)

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        // Iterate through each number in the array
        for (int num : nums) {
            // Use bitwise XOR to find the unique number
            result ^= num;
        }
        
        // Return the unique number
        return result;
    }
}
