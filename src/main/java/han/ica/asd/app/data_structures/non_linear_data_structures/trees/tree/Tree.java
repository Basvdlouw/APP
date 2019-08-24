package han.ica.asd.app.data_structures.non_linear_data_structures.trees.tree;

public class Tree<T> {
    TreeNode root;

    public Tree() {
    }

    public Tree(T rootData) {
        root = new TreeNode<>(rootData);
    }
}
