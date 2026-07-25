public class Solution {
    public int mySqrt(int x) {
        // Handle small numbers directly
        if (x < 2) return x;
        
        long left = 1, right = x / 2;
        int ans = 0;
        
        // Perform binary search
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            
            if (square == x) {
                return (int) mid;
            } else if (square < x) {
                ans = (int) mid; // Store mid as potential answer
                left = mid + 1;  // Move to right half
            } else {
                right = mid - 1; // Move to left half
            }
        }
        
        return ans;
    }
}
