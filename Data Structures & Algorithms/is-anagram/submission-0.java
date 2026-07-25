class Solution {
    public boolean isAnagram(String s, String t) {

        // Step 1: Length check
        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: Frequency array for 26 letters
        int[] count = new int[26];

        // Step 3: Count characters in s
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        // Step 4: Remove characters using t
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
        }

        // Step 5: Check if all counts are zero
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
