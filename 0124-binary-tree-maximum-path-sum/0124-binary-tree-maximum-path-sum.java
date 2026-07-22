/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        int maxSum[] = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        helper(root,maxSum);
        return maxSum[0];
    }
    public int helper(TreeNode root,int maxSum[]){
        if(root == null) return 0;
        int ls = Math.max(0,helper(root.left,maxSum));
        int rs = Math.max(0,helper(root.right,maxSum));
        maxSum[0] = Math.max(maxSum[0],ls + rs + root.val);
        return Math.max(ls,rs) + root.val;
    }
}