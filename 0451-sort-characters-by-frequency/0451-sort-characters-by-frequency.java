class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        // t = 1, r = 1, e = 2;
        int n = s.length();
        List<Character>[] list = new ArrayList[n+1];
        for(Map.Entry<Character, Integer> en : map.entrySet()){
            char ch = en.getKey();
            int freq = en.getValue();
            if(list[freq] == null) list[freq] = new ArrayList<>();
            list[freq].add(ch);
        }
        //  1 -> t, r  2 -> e
        StringBuilder sb = new StringBuilder();
        for(int i=n; i>=0; i--){
            if(list[i] != null){
                for(char ch : list[i]){
                    for(int j=0; j<i; j++) sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}