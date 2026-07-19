class Solution {
    public int trap(int[] height) {
         
         // 0 1 1 2 2 2 2 3 3 3 3 3
         //                        1   h = 0 3,1 1 - 0 = 1 
         int n = height.length;
        //  int leftMax[] = new int[n];
         int rightMax[] = new int[n];
        int leftMax = 0;
         rightMax[n-1] = height[n-1];
        //  for(int i=1; i<n; i++){
        //     leftMax[i] = Math.max(height[i], leftMax[i-1]);
        //  }
         for(int i=n-2; i>=0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
         }
         int water = 0;
        for(int i=0; i<n; i++){
            leftMax = Math.max(leftMax, height[i]);
            int temp = Math.min(leftMax, rightMax[i]) - height[i]; 
            water += temp;
        }
        
         return water;
    }     
}