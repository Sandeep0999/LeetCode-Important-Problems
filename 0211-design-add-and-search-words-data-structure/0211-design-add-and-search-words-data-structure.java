class Trie{
    Trie links[];
    boolean flag;

    public Trie(){
        links = new Trie[26];
        flag = false;
    }

    public boolean contains(char ch){
        return links[ch - 'a'] != null;
    }

    public void put(char ch, Trie node){
        links[ch - 'a'] = node;
    }

    public Trie get(char ch){
        return links[ch - 'a'];
    }

    public void setEnd(){
        flag = true;
    }
    public boolean isEnd(){
        return flag;
    }
}
class WordDictionary {
    private static Trie root;

    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        Trie node = root;
        for(char ch : word.toCharArray()){
            if(!node.contains(ch)){
                node.put(ch, new Trie());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        return recursion(word, 0, root);
    }
    public boolean recursion(String word, int i, Trie node){
        if(i == word.length()) return node.isEnd();
        char ch = word.charAt(i);

        if(ch != '.'){
            if(!node.contains(ch)) return false;
            return recursion(word, i + 1, node.get(ch));
        }

        for(int j=0; j<26; j++){
            if(node.links[j] != null){
                if(recursion(word, i + 1, node.links[j])) return true;           
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */