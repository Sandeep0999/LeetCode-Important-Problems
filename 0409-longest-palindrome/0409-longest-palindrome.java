class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int count = 0;
        boolean odd = false;
        for(int i : map.values()){
            if(i % 2 == 0) count += i;
            else{
                count += i - 1;
                odd = true;
            }
        }
        return odd ? count + 1 : count;
    }
}