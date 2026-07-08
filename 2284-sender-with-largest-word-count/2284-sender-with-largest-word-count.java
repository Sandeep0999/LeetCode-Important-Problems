class Solution {
    public String largestWordCount(String[] m, String[] s) {
        int n = m.length;
        TreeMap<String, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for(int i=0; i<n; i++){
            String arr[] = m[i].split(" ");
            int len = arr.length;
            map.put(s[i], map.getOrDefault(s[i], 0) + len);
        }
        String ans = " ";
        int max = 0;
        for(Map.Entry<String, Integer> en : map.entrySet()){
            int freq = en.getValue();
            String name = en.getKey();
            if(freq > max){
                ans = name;
                max = freq;
            }
        }
        return ans;
    }
}