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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null)
            return root;

        if(key > root.val)
            root.right = deleteNode(root.right, key);
        else if(key < root.val)
            root.left = deleteNode(root.left, key);
        else{
            if(root.right == null)
                return root.left;
            else if(root.left == null)
                return root.right;
            else{
                TreeNode smallest = smallestNode(root.right);
                root.val = smallest.val;
                root.right = deleteNode(root.right, smallest.val);
            }
        }

        return root;

    }

    public TreeNode smallestNode(TreeNode root){

        TreeNode curr = root;

        while(curr != null && curr.left != null){
            curr = root.left;
        }

        return curr;

    }
}