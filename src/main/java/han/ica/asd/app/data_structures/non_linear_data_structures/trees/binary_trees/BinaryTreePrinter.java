package han.ica.asd.app.data_structures.non_linear_data_structures.trees.binary_trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class BinaryTreePrinter {
    public static <T extends Comparable<T>> void printNode(BinaryTreeNode<T> root) {
        printNodeInternal(Collections.singletonList(root), 1, BinaryTreePrinter.maxLevel(root));
    }

    private static <T extends Comparable<T>> void printNodeInternal(List<BinaryTreeNode<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BinaryTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BinaryTreePrinter.printWhitespaces(firstSpaces);

        List<BinaryTreeNode<T>> newNodes = new ArrayList<>();
        nodes.forEach(node -> {
            if (node != null) {
                System.out.print(node.key);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }
            BinaryTreePrinter.printWhitespaces(betweenSpaces);
        });
        System.out.println("");

        IntStream.rangeClosed(1, edgeLines).forEach(i -> {
            nodes.forEach(node -> {
                BinaryTreePrinter.printWhitespaces(firstSpaces - i);
                if (node == null) {
                    BinaryTreePrinter.printWhitespaces(edgeLines + edgeLines + i + 1);
                    return;
                }
                if (node.left != null)
                    System.out.print("/");
                else
                    BinaryTreePrinter.printWhitespaces(1);
                BinaryTreePrinter.printWhitespaces(i + i - 1);
                if (node.right != null)
                    System.out.print("\\");
                else
                    BinaryTreePrinter.printWhitespaces(1);
                BinaryTreePrinter.printWhitespaces(edgeLines + edgeLines - i);
            });
            System.out.println("");
        });
        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        IntStream.range(0, count).mapToObj(i -> " ").forEach(System.out::print);
    }

    private static <T extends Comparable<T>> int maxLevel(BinaryTreeNode<T> node) {
        if (node == null)
            return 0;
        return Math.max(BinaryTreePrinter.maxLevel(node.left), BinaryTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        return list.stream().noneMatch(Objects::nonNull);
    }
}

