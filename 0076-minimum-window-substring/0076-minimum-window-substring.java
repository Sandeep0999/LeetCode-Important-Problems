class Solution {
    public String minWindow(String s, String t) {
        int need[] = new int[128];
        int req = 0;
        for(char ch : t.toCharArray()){
            if(need[ch] == 0) req++;
            need[ch]++;
        }

        int left = 0;
        int formed = 0;
        int minlen = Integer.MAX_VALUE;
        int start = 0;
        int check[] = new int[128];
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            check[ch]++;
            if(need[ch] > 0 && check[ch] == need[ch]) formed++;
            while(formed == req){
                if (right - left + 1 < minlen) {
                    minlen = right - left + 1;
                    start = left;
                }
                char leftch = s.charAt(left);
                check[leftch]--;
                if(need[leftch] > 0 && check[leftch] < need[leftch]) formed--;
                left++;
            }
        } 
        return minlen == Integer.MAX_VALUE ? "" : s.substring(start, start + minlen);
    }
}