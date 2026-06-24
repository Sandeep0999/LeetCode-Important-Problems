class Solution {
    public int[] topKFrequent(int[] nums, int k) {
     HashMap<Integer,Integer> map = new HashMap<>();

     for(int i : nums){
        map.put(i,map.getOrDefault(i,0)+1);
     }
     Queue<Integer> q = new PriorityQueue<>((n1,n2) -> map.get(n1) - map.get(n2));
        for(int n : map.keySet()){
            q.add(n);
            if(q.size() > k){
                q.poll();
            }
        }
        int arr[] = new int[k];
        for(int i=0;i<k;i++){
            arr[i] = q.poll();
        }
        return arr;
    }
}