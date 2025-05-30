package trees.LowestCommonA;

public class MainBST {
    
    public static void main(String[] args) {
        /*
                6
               / \
              2   8
             / \ / \
            0  4 7  9
              / \
             3   5
        */
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        TreeNode p = root.left;         // node 2
        TreeNode q = root.right;    // node 8

        SolutionBST solution = new SolutionBST();

        TreeNode lca = solution.lowestCommonAncestor(null, p, q);

        if(lca != null) {
            System.out.println("LCA of " + p.data + " and " + q.data + " is: " + lca.data);
        } else {
            System.out.println("The result is null");
        }
    }
}
