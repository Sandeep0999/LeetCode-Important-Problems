class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        helper(0,nums,ans,l);
        return ans;
    }
    public void helper(int i,int nums[],List<List<Integer>> ans, List<Integer>l){
        ans.add(new ArrayList<>(l));

        for(int j=i;j<nums.length;j++){
            if(j>i && nums[j]==nums[j-1]) continue;
            l.add(nums[j]);
            helper(j+1,nums,ans,l);
            l.remove(l.size()-1);
        }
    }
}