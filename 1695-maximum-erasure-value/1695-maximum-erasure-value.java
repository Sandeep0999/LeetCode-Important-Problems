class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int sum = 0;
        int left = 0;
        int maxSum = 0;
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            while(set.contains(i)){
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            set.add(i);
            sum += i;
            maxSum = Math.max(sum, maxSum);
        }
    return maxSum;
    }
}