public class AVL_Incalss { 
    Node root; // Initial root node

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
        AVL_Incalss tree = new AVL_Incalss();

        // Create the tree manually
        tree.root = new Node(8);
        tree.root.left = new Node(2);
        tree.root.right = new Node(10);
        tree.root.right.left = new Node(9);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(5);

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
