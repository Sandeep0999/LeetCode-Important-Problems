class Solution {
    public int countDays(int days, int[][] m) {
        int n = m.length;
        if (n == 0) return days;

        Arrays.sort(m, (a, b) -> (a[0] - b[0]));

        int count = 0;
        int curr[] = m[0];
        ArrayList<int[]> arr = new ArrayList<>();

        for(int i=1; i < n; i++){

            if(curr[1] >= m[i][0]) curr[1] = Math.max(curr[1], m[i][1]);

            else{
                arr.add(curr);
                curr = m[i];
            }
        }

        arr.add(curr);

        int len = arr.size();
        
        count += arr.get(0)[0] - 1;
        count += days - arr.get(len - 1)[1];

        for(int i=1; i<len; i++){
            count += arr.get(i)[0] - arr.get(i-1)[1] - 1;
        }
        return count;
    }
}