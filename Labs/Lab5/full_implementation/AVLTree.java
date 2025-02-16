// Lab 05 – Trees 
 
 
// Task 1 
 
// Have a look at the following Java class for an AVL tree node. 
 
// class Node 
// { 
// int key, height; 
// Node left, right; 
 
// Node(int d) 
// { 
// key = d; 
// height = 1; 
// } 
// } 
   
// The height of a node is calculated as the height of the taller of its subtrees + 1. 
// When a node is created, its height is initialized to 1. 
 
// Consider the given AVL tree below. 
 
// 1.  Implement the above AVL tree using the given Node class. 
// 2.  Write methods for tree traversal: 
// Pre-order 
// In-order 
// Post-order 
// Write a main method to demonstrate these traversals on your AVL tree.

public class AVLTree {
    Node root; // Initial root node

    int height(Node N) {
        // return the height of the node
        return (N == null) ? 0 : N.height;
    }

    int getBalance(Node N) {
        // return the (left height - right height) of the node (to decide which rotaion to apply)
        return (N == null) ? 0 : height(N.left) - height(N.right);
    }

    Node rightRotate(Node y) {
        // Get the left as x and right as T2
        Node x = y.left;
        Node T2 = x.right;

        // Perform the rotation
        x.right = y;
        y.left = T2;

        // Update the heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    Node leftrightRotate(Node z) {
        z.left = leftRotate(z.left);
        return rightRotate(z);
    }

    Node rightleftRotate(Node z) {
        z.right = rightRotate(z.right);
        return leftRotate(z);
    }

    Node insert(Node node, int key) {
        if (node == null)
            return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key + " ");
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        int[] keys = { 8, 2, 10, 9, 1, 5 };
        for (int key : keys) {
            tree.root = tree.insert(tree.root, key);
        }

        System.out.println("Preorder traversal: ");
        tree.preOrder(tree.root);
        System.out.println();

        System.out.println("Inorder traversal: ");
        tree.inOrder(tree.root);
        System.out.println();

        System.out.println("Postorder traversal: ");
        tree.postOrder(tree.root);
        System.out.println();
    }
}

class Node {
    int key, height;
    Node left, right;

    public Node(int var1) {
        this.key = var1; // Set Root value 
        this.height = 1; // dafault height of a node is 1
    }
}
