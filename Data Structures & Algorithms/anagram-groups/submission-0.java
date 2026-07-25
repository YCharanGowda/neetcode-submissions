class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // Map to store sorted word -> list of anagrams
        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            // Convert word to char array and sort
            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            // Convert back to string to use as key
            String key = new String(chars);

            // If key not present, create new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add original word to the list
            map.get(key).add(word);
        }

        // Return all grouped values
        return new ArrayList<>(map.values());
    }
}
