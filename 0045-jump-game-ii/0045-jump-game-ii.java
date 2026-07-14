class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int step = 0, currEnd = 0;
        int farthest = 0;
        for(int i = 0; i < n - 1; i++){
            farthest = Math.max(farthest, nums[i] + i);
            if(currEnd == i){
                step++;
                currEnd = farthest;
            }
        }
        return step;
    }
}