class Solution {
    public String convert(String s, int n) {
        if(n == 1) return s;
        StringBuilder rows[] = new StringBuilder[n];

        for(int i=0; i<n; i++) rows[i] = new StringBuilder();
        int curr = 0;
        boolean down = true;
        for(char ch : s.toCharArray()){
            rows[curr].append(ch);
            if(curr == 0) down = true;
            if(curr == n - 1) down = false;
            if(down) curr++;
            else curr--;
        }
        StringBuilder ans = new StringBuilder();
        for(StringBuilder a : rows) ans.append(a);
        return ans.toString();
    }
}