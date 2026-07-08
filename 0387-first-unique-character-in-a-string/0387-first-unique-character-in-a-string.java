class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        char first = ' ';
        for(char ch : map.keySet()){
            if(map.get(ch) == 1){
                first = ch;
                break;
            }
        }
        if(first == ' ') return -1;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == first) return i;
        }
        return -1;
    }
}