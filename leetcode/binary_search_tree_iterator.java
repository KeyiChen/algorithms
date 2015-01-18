/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private TreeNode cur, next;
    
    public BSTIterator(TreeNode root) { cur = root; }

    /** @return whether we have a next smallest number */
    public boolean hasNext() { return cur != null; }

    /** @return the next smallest number */
    public int next() {
        TreeNode result = null;
        while (cur != null) {
            next = cur.left;
            if (next == null) {
                result = cur;
                cur = cur.right;
                break;
            } else {
                while (next.right != null && next.right != cur) next = next.right;
                if (next.right == cur) {
                    result = cur;
                    cur = cur.right;
                    next.right = null;
                    break;
                } else {
                    next.right = cur;
                    cur = cur.left;
                }
            }
        }
        
        return result.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
