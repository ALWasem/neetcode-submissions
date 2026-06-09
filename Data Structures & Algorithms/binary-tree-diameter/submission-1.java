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

    int diameter;

    public int diameterOfBinaryTree(TreeNode root) {

        diameter = 0;
        int x = heightDFS(root);
        return diameter;
        
    }
    
    public int heightDFS(TreeNode curr){
        if(curr == null)
            return 0;

        int leftH = heightDFS(curr.left);
        int rightH = heightDFS(curr.right);

        diameter = Math.max(diameter, leftH + rightH);

        return 1 + Math.max(leftH, rightH);
    }
}
