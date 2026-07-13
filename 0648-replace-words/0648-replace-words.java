class Trie{
    Trie links[];
    boolean flag;

    public Trie(){
        links = new Trie[26];
        flag = false;
    }
    boolean contains(char ch){
        return links[ch - 'a'] != null;
    }
    void put(char ch, Trie node){
        links[ch - 'a'] = node;
    }
    Trie get(char ch){
        return links[ch - 'a'];
    }
    void setEnd(){
        flag = true;
    }
    boolean isEnd(){
        return flag;
    }
}
class Solution {
    public Trie root = new Trie();

    public String replaceWords(List<String> d, String s) {
        addToTrie(d);
        StringBuilder ans = new StringBuilder();

        String[] words = s.split(" ");

        for (int i = 0; i < words.length; i++) {
            ans.append(check(words[i]));
            if (i != words.length - 1)
                ans.append(" ");
        }
        return ans.toString();
    }

    public void addToTrie(List<String> d){
        for(String i : d){
            Trie node = root;
            for(char ch : i.toCharArray()){
                if(!node.contains(ch)){
                    node.put(ch, new Trie());
                }
                node = node.get(ch);
            }
            node.setEnd();
        }
    }
    public String check(String str){
        Trie node = root;
        StringBuilder sb = new StringBuilder();

        for(char ch : str.toCharArray()){
            if(!node.contains(ch)) return str;
            node = node.get(ch);
            sb.append(ch);
            if(node.isEnd()) return sb.toString();
        }
        return str;
    }
}