class Solution {
    public int lengthOfLongestSubstring(String s) {
        ArrayList<Character>set = new ArrayList<>();

        if(s.length()==0) return 0;
        int max = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            while(set.contains(ch)){
                set.remove(0);
            }
            set.add(ch);
            max = Math.max(max,set.size());
        }
        return max;
    }
}