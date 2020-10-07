import java.util.*;

//problem
/*
Write a function that takes a binary tree and returns a list of its branch sums ordered from leftmost
branch sum to rightmost branch sum.
A branch sum is the sum of all values in a binary tree branch.

Input:       1
          2          3
      4       5     6  7
    8   9   10

Output: [15,16,18,10,11]
//15 = 1 + 2 + 4 + 8
//16 = 1 + 2 + 4 + 9
etc
 */

class Program {

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private void preorderTraversal(BinaryTree node, int branchSum, List<Integer> branchSums) {
        if (node == null) return; // return from the function if we are in dead end
        branchSum += node.value;

        if (node.left == null && node.right == null) {
            branchSums.add(branchSum);
            return; // return from the function if we reached dead end
        }
        preorderTraversal(node.left, branchSum, branchSums);
        preorderTraversal(node.right, branchSum, branchSums);
    }

    public List<Integer> branchSums(BinaryTree root) {
        List<Integer> branchSums = new ArrayList<>();
        preorderTraversal(root, 0, branchSums);
        return branchSums;
    }
}