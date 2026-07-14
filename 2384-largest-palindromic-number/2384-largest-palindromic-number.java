class Solution {
    public String largestPalindromic(String num) {
        TreeMap<Character, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        
        for(char i : num.toCharArray()){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        char mid = 0;

        for(Map.Entry<Character, Integer> en : map.entrySet()){
            char key = en.getKey();
            int val = en.getValue();
            
            int half = val / 2;
            
            for(int i=0; i < half; i++){
                sb.append(key);
            }
            if (val % 2 == 1 && key > mid) {
                mid = key;
            } 
        }
        while(sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        StringBuilder ans = new StringBuilder();
        ans.append(sb);

        if(mid != 0) ans.append(mid);

        ans.append(new StringBuilder(sb).reverse());

        if(ans.length() == 0) return "0";
        return ans.toString();
    }
}