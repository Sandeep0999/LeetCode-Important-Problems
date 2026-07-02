class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int idx = 1;
        int max = 0;
        int n = citations.length;
        for(int i=n-1; i>=0; i--){
            if(idx <= citations[i]){
                max = idx;
            }
            idx++;
        }
        return max;
    }
}