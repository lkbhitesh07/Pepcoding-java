import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int data;
        Node left;
        Node right;
        
        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    
    public static class Pair {
        int state;
        Node node;
        
        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    
    public static void display(Node node) {
        if(node == null) {
            return;
        }
        // to handle node part
        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        
        System.out.println(str);
        
        display(node.left);
        display(node.right);
    }
    
    public static void main(String[] args) {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Node root = new Node(arr[0], null, null);
        Pair rp = new Pair(root, 1);
        Stack<Pair> st = new Stack<>();
        st.push(rp);
        
        int idx = 0;
        while(st.size() > 0) {
            Pair top = st.peek();
            if(top.state == 1) {
                idx++;
                if(arr[idx] != null) {
                   top.node.left = new Node(arr[idx], null, null);

                   Pair ln_pair = new Pair(top.node.left, 1);
                   st.push(ln_pair);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if(top.state == 2) {
                idx++;
                if(arr[idx] != null) {
                   top.node.right = new Node(arr[idx], null, null);
                   Pair rn_pair = new Pair(top.node.right, 1);
                   st.push(rn_pair);
                } else {
                    top.node.right = null;
                }
                top.state++;
            } else {
                st.pop();
            }
        }
        
        display(root);
    }
}
