class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        for(char ch : magazine.toCharArray()){
            map1.put(ch, map1.getOrDefault(ch, 0)+1);
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char ch : ransomNote.toCharArray()){
            map2.put(ch, map2.getOrDefault(ch, 0)+1);
        }
        for(char ch : map2.keySet()){
            if(!map1.containsKey(ch)) return false;
            else if(map1.get(ch) < map2.get(ch)) return false;
        }
        return true;
    }
}