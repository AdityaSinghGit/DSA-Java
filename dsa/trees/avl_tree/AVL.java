package trees.avl_tree;

public class AVL {
    private Node root;

    AVL() {

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

    public int height() {
        return getHeight(root);
    }

    private int getHeight(Node node) {
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

        return rotate(node);
    }

    private Node rotate(Node node) {
        if ((getHeight(node.left) - getHeight(node.right)) > 1) {
            // left heavy
            if (getHeight(node.left.left) - getHeight(node.left.right) > 0) {
                // left-left
                return rotateRight(node);
            }

            if (getHeight(node.left.left) - getHeight(node.left.right) < 0) {
                // left-right
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }

        }

        if ((getHeight(node.left) - getHeight(node.right)) < -1) {
            // right heavy
            if (getHeight(node.right.left) - getHeight(node.right.right) < 0) {
                // right-right
                return rotateLeft(node);
            }

            if (getHeight(node.right.left) - getHeight(node.right.right) > 0) {
                // right-left
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }

        return node;
    }

    private Node rotateRight(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
        c.height = Math.max(getHeight(c.left), getHeight(c.right)) + 1;

        return c;
    }

    private Node rotateLeft(Node c) {
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
        c.height = Math.max(getHeight(c.left), getHeight(c.right)) + 1;

        return p;
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
        AVL tree = new AVL();
        for (int i = 0; i < 1000; i++) {
            tree.insert(i);
        }

        System.out.println(tree.height());

    }

}
