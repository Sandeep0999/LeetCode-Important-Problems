class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = n2-1; i >= 0; i--){
            int num = nums2[i];
            while(!st.isEmpty() && st.peek() <= num){
                st.pop();
            }
            map.put(num,st.isEmpty() ? -1 : st.peek());
            st.push(num);
        }
        for (int i = 0; i < n1; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}