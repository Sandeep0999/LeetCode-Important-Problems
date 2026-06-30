class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k == 0) return ans;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int m = nums1.length;
        int n = nums2.length;
        for(int i=0; i<Math.min(m, k); i++){
            pq.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }
        while(k-- > 0 && !pq.isEmpty()){
            int arr[] = pq.poll();
            int i = arr[1], j = arr[2];
            ans.add(Arrays.asList(nums1[i], nums2[j]));
            if(j + 1 < n){
                pq.offer(new int[]{nums1[i] + nums2[j+1], i, j+1});
            }
        }
        return ans; 
    }
}