class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length; 
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    public int atMostK(int nums[], int k){
        int n = nums.length;
        int left = 0;
        int count = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int right = 0; right < n; right++){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while(map.size() > k){
                int leftNum = nums[left];
                map.put(leftNum, map.get(leftNum) - 1);
                
                if(map.get(leftNum) == 0) map.remove(leftNum);
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}