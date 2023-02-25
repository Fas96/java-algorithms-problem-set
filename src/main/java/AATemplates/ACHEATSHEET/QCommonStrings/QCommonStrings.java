package AATemplates.ACHEATSHEET.QCommonStrings;

public class QCommonStrings {
    class Trie {
        private class TrieNode {
            public boolean isWord = false;
            public TrieNode[] nodes = new TrieNode[26];
        }
        TrieNode root = new TrieNode();
        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (cur.nodes[index] == null) cur.nodes[index] = new TrieNode();
                cur = cur.nodes[index];
            }
            cur.isWord = true;
        }
        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (cur.nodes[index] == null) return false;
                cur = cur.nodes[index];
            }
            return cur.isWord;
        }
        /** Returns if there is any word in the trie
         that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                int index = c - 'a';
                if (cur.nodes[index] == null) return false;
                cur = cur.nodes[index];
            }
            return true;
        }
    }
}
