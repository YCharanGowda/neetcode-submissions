class PrefixTree {

    // Helper class to represent each node in the Trie
    private class TrieNode {
        private TrieNode[] children;
        private boolean isEndOfWord;

        public TrieNode() {
            // Assuming lowercase English letters 'a' through 'z'
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    /** Inserts a word into the prefix tree. */
    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a'; // Map character to 0-25
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }

    /** Returns true if the word is in the prefix tree. */
    public boolean search(String word) {
        TrieNode node = getLastNode(word);
        return node != null && node.isEndOfWord;
    }

    /** Returns true if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return getLastNode(prefix) != null;
    }

    /** Helper method to navigate to the last node of a string */
    private TrieNode getLastNode(String s) {
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                return null;
            }
            curr = curr.children[index];
        }
        return curr;
    }
}
