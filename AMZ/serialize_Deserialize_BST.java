// Encodes a tree to a single string.
public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    traverse(root, sb);
    return sb.toString();
}

private void traverse(TreeNode node, StringBuilder sb) {
    if (node == null) {
        sb.append("null,");
    } else {
        sb.append(node.val+",");
        traverse(node.left, sb);
        traverse(node.right,sb);
    }
}
// Decodes your encoded data to tree.
public TreeNode deserialize(String data) {
    Queue<String> nodes = new LinkedList<>();
    nodes.addAll(Arrays.asList(data.split(",")));
    return buildTree(nodes);
}
//use queue to get rid of used strings
private TreeNode buildTree(Queue<String> nodes) {
    String val = nodes.remove();
    if (val.equals("null")) return null;
    else {
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }
}
