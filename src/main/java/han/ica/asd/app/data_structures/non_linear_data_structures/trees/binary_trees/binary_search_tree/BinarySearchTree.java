package han.ica.asd.app.data_structures.non_linear_data_structures.trees.binary_trees.binary_search_tree;

import han.ica.asd.app.data_structures.non_linear_data_structures.trees.binary_trees.BinaryTreeNode;

public class BinarySearchTree<T extends Comparable<T>> {
    BinaryTreeNode<T> root;

    BinarySearchTree() {
        root = null;
    }

    BinarySearchTree(T value) {
        root = new BinaryTreeNode<>(value);
    }

    public void insert(T key) {
        root = insertRec(root, key);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public T find(T value) {
        return root.find(value).key;
    }

    private BinaryTreeNode insertRec(BinaryTreeNode root, T key) {
        /* If the trees is empty, return a new node */
        if (root == null) {
            root = new BinaryTreeNode(key);
            return root;
        }
        /* Otherwise, recur down the trees */
        if (key.compareTo((T) root.key) < 0)
            root.left = insertRec(root.left, key);
        else if (key.compareTo((T) root.key) > 0)
            root.right = insertRec(root.right, key);
        /* return the (unchanged) node pointer */
        return root;
    }

    private BinaryTreeNode<T> findMin(BinaryTreeNode node) {
        if (node.left != null) {
            return findMin(node.left);
        } else {
            return node;
        }
    }

    /**
     * wrapper method
     *
     * @return lowest value in BST
     */
    public T findMin() {
        return findMin(root).key;
    }

    private BinaryTreeNode<T> findMax(BinaryTreeNode node) {
        if (node.right != null) {
            return findMax(node.right);
        } else {
            return node;
        }
    }

    /**
     * wrapper method
     *
     * @return highest value in BST
     */
    public T findMax() {
        return findMax(root).key;
    }

    public void delete(T data) {
        deleteNode(this.root, data);
    }

    private BinaryTreeNode deleteNode(BinaryTreeNode root, T data) {
        if (root == null)
            return null;
        if (data.compareTo((T) root.key) < 0) {
            root.setLeft(deleteNode(root.left, data));
        } else if (data.compareTo((T) root.key) > 0) {
            root.setRight(deleteNode(root.right, data));
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                T minValue = findMin(root.right).key;
                root.key = minValue;
                root.setRight(deleteNode(root.right, minValue));
            }
        }
        return root;
    }

    void printTree(BinaryTreeNode node, String prefix)
    {
        if(node == null) return;

        System.out.println(prefix + " + " + node.key);
        printTree(node.left , prefix + " ");
        printTree(node.right , prefix + " ");
    }
}
