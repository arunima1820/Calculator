/**
 *
 * @author Arunima Mittra
 * Implementing an AST(Abstract Syntax Tree) data structure
 * to calculate an operation using PEMDAS
 */
public class Calculate {
    Node root;
    
    Calculate(int key) {
        root = new Node (key);
    }
    
    Calculate() {
        root = null;
    }
    
    public void put(int val) {
        Calculate tree = new Calculate();
        tree.root = new Node(val);        
    }
    
    
    
}

class Node {
    int key;
    Node left, right;
    
    public Node(int item) {
        key = item;
        left = right = null;
    }
} 
