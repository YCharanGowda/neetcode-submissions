class Solution {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();
        s = s.replaceAll("[^0-9a-z]","");

        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;

    }
}
