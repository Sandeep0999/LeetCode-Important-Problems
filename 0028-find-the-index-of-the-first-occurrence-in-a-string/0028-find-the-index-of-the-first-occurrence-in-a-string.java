class Solution {
    public int strStr(String haystack, String needle) {
        // if(!haystack.contains(needle)) return -1;
        int sublen = needle.length();
        int idx = -1;
        for(int i=0;i<=haystack.length()-sublen;i++){
            if(haystack.substring(i,i+sublen).equals(needle)){
                idx = i;
                break;
            }
        }
        return idx;
    }
}