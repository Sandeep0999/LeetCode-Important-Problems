class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preIndex++]);

        int inRoot = map.get(root.val);

        root.left = build(preorder, inStart, inRoot - 1);
        root.right = build(preorder, inRoot + 1, inEnd);

        return root;
    }
}