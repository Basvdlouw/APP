package han.ica.asd.app.data_structures.non_linear_data_structures.trees.binary_trees;

public class BinaryTree<T extends Comparable<T>> {
    BinaryTreeNode root;

    public BinaryTree() {}

    public BinaryTree(T value) {
        root = new BinaryTreeNode(value);
    }

    public int getLeafCount(BinaryTreeNode node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        else
            return getLeafCount(node.left) + getLeafCount(node.right);
    }

    void printPostorder(BinaryTreeNode node) {
        if (node == null)
            return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.key + " ");
    }

    void printInorder(BinaryTreeNode node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }

    void printPreorder(BinaryTreeNode node) {
        if (node == null)
            return;
        System.out.print(node.key + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    /**
     * wrapper methods
     */
    public void printPostorder() {
        printPostorder(root);
    }

    public void printInorder() {
        printInorder(root);
    }

    public void printPreorder() {
        printPreorder(root);
    }

    public int getLeafCount() {
        return getLeafCount(root);
    }

}
