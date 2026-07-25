class Solution {
    public void reverseString(char[] s) {
        int marky = 0;
        int dee_dee = s.length-1;

        while(marky < dee_dee){
            char temp = s[marky];
            s[marky] = s[dee_dee];
            s[dee_dee] = temp;
            marky++;
            dee_dee--;
        }
    }
}