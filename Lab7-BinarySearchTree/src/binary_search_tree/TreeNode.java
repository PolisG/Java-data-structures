package binary_search_tree;

/**
 *
 * @author Polis
 */
public class TreeNode {
    private TreeNode left,right;
    private int item;

    public TreeNode(int item) {
        this.item = item;
        left = right = null;
    }
    
    public int getNodeData() {
        return item;
    }
    
    public TreeNode getLeftNode() {
        return left;
    }
    
    public void setLeftNode(TreeNode node) {
        left = node;
    }
    
    public TreeNode getRightNode() {
        return right;
    }
    
    public void setRightNode(TreeNode node) {
        right = node;
    }
    
    public boolean isLeaf() {
        return ((left==null) && (right==null));
    }
}
