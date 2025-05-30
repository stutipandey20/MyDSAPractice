package trees.LowestCommonA;

public class MainBT {
    public static void main(String[] args) {

        /*
              3
             / \
            5   1
           / \ / \
          6  2 0  8
            / \
           7   4
        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left; // root with value 5
        TreeNode q = root.left.right.right; // root with value 4

        SolutionBT solution = new SolutionBT();
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);

        if(lca != null) {
            System.out.println("LCA of " + p.data + " and " + q.data + " is: " + lca.data);
        } else {
            System.out.println("The result is null");
        }

    }
}
