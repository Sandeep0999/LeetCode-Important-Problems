class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int count = n;
        for(int i=1; i<n; i++){
            if(intervals[i-1][1] >= intervals[i][1]) count--;
            if(intervals[i-1][1] <= intervals[i][1] && intervals[i-1][0] == intervals[i][0]) count--;
        }
        return count;
    }
}