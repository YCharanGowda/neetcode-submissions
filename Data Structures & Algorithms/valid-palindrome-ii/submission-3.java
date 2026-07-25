class Solution {
    public boolean validPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]","");

        int left = 0;
        int right = s.length()-1;

        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return isp(s, left+1, right) || isp(s, left, right-1);
            }
            left++;
            right--;
        }
        return true;
    }

        private boolean isp(String s, int left, int right){  

            while(left<right){
                if(s.charAt(left)!=s.charAt(right)){
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }

    
}