class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        // String[] tokens = s.split("\\s+");
        // for(int i=tokens.length-1;i>=0;i--){
        //     sb.append(tokens[i]);
        //     if(i>0){
        //         sb.append(" ");
        //     }
        // }
        int n = s.length();
        int i = n - 1;
        
        while(i >= 0){
            while(i >= 0 && s.charAt(i) == ' ') i--;
            if(i < 0) break;

            int j = i;
            while(j >= 0 && s.charAt(j) != ' '){
                j--;
            }

            sb.append(s.substring(j+1, i+1)).append(" ");
            i = j;
        }
        return sb.toString().trim();
    }
}