// Lab 05 – Trees 
// E/20/280
// Task 1 

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
        // getting the left as x and right as T2
        Node x = y.left;
        Node T2 = x.right;

        // pergormming the rotation
        x.right = y;
        y.left = T2;

        // updating the heights
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
        // insering
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

    Node search(Node root, int key) {
        if (root == null || root.key == key)
            return root;

        if (root.key > key)
            return search(root.left, key);

        return search(root.right, key);
    }

    Node remove(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = remove(root.left, key);
        else if (key > root.key)
            root.right = remove(root.right, key);
        else {
            if ((root.left == null) || (root.right == null)) {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                Node temp = minValueNode(root.right);
                root.key = temp.key;
                root.right = remove(root.right, temp.key);
            }
        }

        if (root == null)
            return root;

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);
  
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);  

  
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }  


        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);
  

        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }   
        return root;


    }
  
    Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;

        return current;
    }

    // traversal methods
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
            // insertig
            tree.root = tree.insert(tree.root, key);
        }
        // Traversing
        System.out.println("Preorder traversal: ");
        tree.preOrder(tree.root);
        System.out.println();

        System.out.println("Inorder traversal: ");
        tree.inOrder(tree.root);
        System.out.println();

        System.out.println("Postorder traversal: ");
        tree.postOrder(tree.root);
        System.out.println();

        // Sarcing
        System.out.println("Search for key 10: " + (tree.search(tree.root, 10) != null ? "Found" : "Not Found"));

        // Removing
        tree.root = tree.remove(tree.root, 10);
        System.out.println("Inorder traversal after removing key 10: ");
        tree.inOrder(tree.root);
        System.out.println();
    }
}

class Node {
    int key, height;
    Node left, right;

    public Node(int var1) {
        this.key = var1; // set the  Root value 
        this.height = 1; // dafault height of a node is 1
    }
}
