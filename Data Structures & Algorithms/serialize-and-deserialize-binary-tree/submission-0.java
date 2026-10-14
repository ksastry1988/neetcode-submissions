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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "#";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder builder = new StringBuilder();

        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr == null){
                builder.append("#,");
            }
            else{
                builder.append(curr.val).append(",");
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) return null;

        String[] strArr = data.split(",");

        if(strArr[0].equals("#")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(strArr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        int i = 1;

        queue.add(root);
        while(!queue.isEmpty() && i < strArr.length){
            TreeNode curr = queue.poll();
            if(i < strArr.length && !strArr[i].equals("#") && !strArr[i].isEmpty()){
                curr.left = new TreeNode(Integer.parseInt(strArr[i]));
                queue.add(curr.left);
            }
            i++;
            if(i < strArr.length && !strArr[i].equals("#") && !strArr[i].isEmpty()){
                curr.right = new TreeNode(Integer.parseInt(strArr[i]));
                queue.add(curr.right);
            }
            i++;
        }
        return root;
    }
}
