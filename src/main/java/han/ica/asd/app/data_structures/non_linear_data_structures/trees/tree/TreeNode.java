package han.ica.asd.app.data_structures.non_linear_data_structures.trees.tree;

public class TreeNode<T> {
    private T value;
    private TreeNode sibling;
    private TreeNode child;

    public T getValue() {
        return value;
    }

    public TreeNode getSibling() {
        return sibling;
    }

    public TreeNode getChild() {
        return child;
    }

    public TreeNode(T value) {
        this.value = value;
    }

    public void addSibling(T value) {
        TreeNode node = new TreeNode(value);
        if(sibling == null)
            sibling = node;
        else {
            node.addSibling(sibling.getValue());
            sibling = node;
        }
    }

    public void addChild(T value) {
        TreeNode node = new TreeNode(value);
        if (child == null)
            child = node;
        else {
            node.addSibling(child.getValue());
            child = node;
        }
    }

    public void removeChild() {
        child = null;
    }

    public void removeSibling() {
        sibling = null;
    }
}
