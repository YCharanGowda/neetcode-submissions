class Solution {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]","");

        int marky=0;
        int dee_dee=s.length()-1;

        while(marky<dee_dee){
            if(s.charAt(marky) != s.charAt(dee_dee)){
                return false;
            }
            marky++;
            dee_dee--;
        }
        return true;

    }
}
