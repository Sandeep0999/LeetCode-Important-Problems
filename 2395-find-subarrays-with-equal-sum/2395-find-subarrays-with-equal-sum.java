class Solution {
    public boolean findSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int prev = nums[0];
        for(int i = 1; i < nums.length; i++){
            int sum = prev + nums[i];
            if(!set.add(sum)) return true;
            prev = nums[i];
        }
        return false;
    }
}