import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }
  
  // calculate something and return something else -> new pattern.
  static int max_sum_node = 0;
  static int max_sum_value = Integer.MIN_VALUE;
  public static int nodeWithMaxSubtree(Node node){
      int sum = 0;
      
      for(Node child: node.children){
          int child_sum = nodeWithMaxSubtree(child);
          sum += child_sum;
      }
      
      sum += node.data;
      
      if(sum > max_sum_value){
          max_sum_value = sum;
          max_sum_node = node.data;
      }
      return sum;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    // write your code here
    int sum = nodeWithMaxSubtree(root);
    System.out.print(max_sum_node + "@" + max_sum_value);
  }

}
