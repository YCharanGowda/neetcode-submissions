class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int count = 0;
        int sum = 0;

        int target = k * threshold;

    
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        if (sum >= target) count++;

        
        for (int i = k; i < n; i++) {
            sum += arr[i];        
            sum -= arr[i - k];    

            if (sum >= target) count++;
        }

        return count;
    }
}