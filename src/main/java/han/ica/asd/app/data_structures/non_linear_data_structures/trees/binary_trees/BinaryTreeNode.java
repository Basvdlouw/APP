package han.ica.asd.app.data_structures.non_linear_data_structures.trees.binary_trees;

public class BinaryTreeNode<T extends Comparable<T>> {
    public T key;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(T value) {
        this.key = value;
    }

    public void addLeft(T value) {
        left = new BinaryTreeNode(value);
    }

    public void addRight(T value) {
        right = new BinaryTreeNode(value);
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public BinaryTreeNode<T> find(T value) {
        if (value.compareTo(key) < 0) {
            return left.find(value);
        } else if (value.compareTo(key) > 0) {
            return right.find(value);
        } else if (value.compareTo(key) == 0) {
            return this;
        } else {
                return null;
        }
    }
}
