package trees;

public class CustomBST {
    private Node root;

    CustomBST() {

    }

    private class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    public int getHeight(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    // Empty check
    public boolean isEmpty() {
        return root == null;
    }

    // Insert
    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            Node newNode = new Node(value);
            return newNode;
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        }

        if (value > node.value) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        return node;
    }

    // Check if tree is balanced
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        return Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1 && isBalanced(node.left)
                && isBalanced(node.right);
    }

    // Add multiple values at once through an array
    public void populate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }

    // To self balance a sorted array tree
    public void populateSorted(int[] arr) {
        populateSorted(arr, 0, arr.length);
    }

    private void populateSorted(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        insert(arr[mid]);
        populateSorted(arr, start, mid);
        populateSorted(arr, mid + 1, end);
    }

    // Display
    public void display() {
        display(root, "Root node : ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }

        System.out.println(details + node.value);

        display(node.left, "Left child of " + node.getValue() + " : ");
        display(node.right, "Right child of " + node.getValue() + " : ");
    }

    // Pre-Order Traversal
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // In-Order Traversal
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.value + " ");
        inOrder(node.right);
    }

    // Post-Order Traversal
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value + " ");
    }

    public static void main(String[] args) {
        CustomBST tree = new CustomBST();
        // int[] arr = { 5, 2, 7, 1, 4, 6, 10, 8, 3 };
        // tree.populate(arr);
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        tree.populateSorted(arr);
        tree.display();
        System.out.println(tree.isBalanced());

    }

}
