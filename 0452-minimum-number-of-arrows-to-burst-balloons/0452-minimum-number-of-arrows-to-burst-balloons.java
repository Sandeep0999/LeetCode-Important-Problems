class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int n = points.length;
        int arrow = 1;
        int x = points[0][1];
        
        for(int i=1; i<n; i++){
            if(points[i][0] > x){
                arrow++;
                x = points[i][1];
            }
        }
        return arrow;
    }
}