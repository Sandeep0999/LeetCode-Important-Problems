
public class Codec {

    private int index;

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) return;

        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;

        String[] arr = data.split(",");
        index = 0;

        return build(arr, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private TreeNode build(String[] arr, long min, long max) {
        if (index == arr.length) return null;

        int val = Integer.parseInt(arr[index]);

        if (val <= min || val >= max)
            return null;

        index++;

        TreeNode root = new TreeNode(val);

        root.left = build(arr, min, val);
        root.right = build(arr, val, max);

        return root;
    }
}
