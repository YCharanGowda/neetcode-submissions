class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if (s1.length() > s2.length()) return false;
        
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        
        // frequency of s1
        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }
        
        int k = s1.length();
        
        for (int i = 0; i < s2.length(); i++) {
            
            // add current character
            count2[s2.charAt(i) - 'a']++;
            
            // remove left character if window exceeded
            if (i >= k) {
                count2[s2.charAt(i - k) - 'a']--;
            }
            
            // compare
            if (matches(count1, count2)) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}