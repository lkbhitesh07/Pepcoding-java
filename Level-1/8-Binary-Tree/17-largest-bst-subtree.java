import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }
  
  public static class isBST {
      int total_ele;
      boolean is_BST;
      int max;
      int min;
  }
  
  static int max_till = Integer.MIN_VALUE;
  static int max_ele = 0;
  public static isBST LargestBST(Node node) {
      
      if (node == null) {
          isBST base = new isBST();
          base.total_ele = 0;
          base.is_BST = true;
          base.max = Integer.MIN_VALUE;
          base.min = Integer.MAX_VALUE;
          
          return base;
      }
      
      isBST left_part = LargestBST(node.left);
      isBST right_part = LargestBST(node.right);
      
      isBST main = new isBST();
      main.total_ele = left_part.total_ele + right_part.total_ele + 1;
      main.is_BST = left_part.is_BST && right_part.is_BST &&
                    (left_part.max <= node.data && right_part.min >= node.data);
      main.min = Math.min(node.data, Math.min(left_part.min, right_part.min));
      main.max = Math.max(node.data, Math.max(left_part.max, right_part.max));
      
      if (main.is_BST) {
          if (main.total_ele > max_ele) {
              max_ele = main.total_ele;
              max_till = node.data;
          }
      }
      
      return main;
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    
    // write your code here
    isBST ans = LargestBST(root);
    System.out.println(max_till + "@" + max_ele);
  }

}
