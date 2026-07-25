class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        // 1. Iterate through the array and mark seen numbers
        for (int i = 0; i < nums.length; i++) {
            // Use the value at the current index to find the target index.
            // We use abs() because the value might have been negated by a previous step.
            int index = Math.abs(nums[i]) - 1;
            
            // Mark the value at 'index' as negative if it's not already
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        
        // 2. Second pass: find indices that contain positive values
        for (int i = 0; i < nums.length; i++) {
            // If the value is still positive, the number (i + 1) was never seen.
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        
        return result;
    }
}
