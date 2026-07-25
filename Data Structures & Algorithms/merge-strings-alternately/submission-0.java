class Solution {
    public String mergeAlternately(String word1, String word2) {
            StringBuffer s=new StringBuffer();

            int marky=0,dee_dee=0;

            while(marky < word1.length() && dee_dee < word2.length()){
                s.append(word1.charAt(marky));
                s.append(word2.charAt(dee_dee));
                marky++;
                dee_dee++;
            }

            while(marky < word1.length()){
                s.append(word1.charAt(marky));
                marky++;
            }

            while(dee_dee < word2.length()){
                s.append(word2.charAt(dee_dee));
                dee_dee++;
            }

            return s.toString();
    }
}