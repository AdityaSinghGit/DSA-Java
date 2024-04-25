package trees;

import java.util.Scanner;

public class CustomBinaryTree {

    private Node root;

    public CustomBinaryTree() {

    }

    private class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    // Insert element
    public void populate(Scanner scanner) {
        System.out.println("Enter the root value : ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to add a left node for " + node.value);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter value for left node : ");
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        System.out.println("DO you want to add a right node for " + node.value);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter value for right node : ");
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }

    }
    // ------------X------------X------------X------------

    // Display
    public void display() {
        display(root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }

        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }
    // ------------X------------X------------X------------

    // Pretty display
    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        prettyDisplay(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.value);
        } else {
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level + 1);
    }
    // ------------X------------X------------X------------

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomBinaryTree tree = new CustomBinaryTree();
        tree.populate(scanner);
        tree.prettyDisplay();
    }
}
