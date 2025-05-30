package trees.LowestCommonA;

public class SolutionBST {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null || p == null || q == null) return null;
        
        if (p.data < root.data && q.data < root.data) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.data > root.data && q.data > root.data) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
/*
 * same solution as BT can work, this one is little more optimized.
 * Why a Special BST Solution Could Be More Efficient
If the tree is a BST, you can use the ordering property to optimize:
BST Property:
All nodes in the left subtree have values < root.val
All nodes in the right subtree have values > root.val

Time: O(log N) in balanced BST
Space: O(H), recursion stack
 */