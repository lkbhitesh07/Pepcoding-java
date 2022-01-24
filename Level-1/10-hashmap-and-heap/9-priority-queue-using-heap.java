import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }

    // If array is passed and we have to create PQ

    public PriorityQueue(int[] arr) {
      data = new ArrayList<>();
      for(int val: arr) {
        data.add(val);
      }
    // There are 2 methods to solve this, one is to keep calling the "add" function which will result
    // in calling upheapify several times and for the h length of elements uphea[ify will be called 
    // for every elements and it will be costly for us as it will be nlog(n) comp.
    // Now the second method is to call downheapify at the h-1 length and move upwards, this way only one 
    // element(root) which may travel h length at downheapify. 
      for(int i = data.size()/2-1; i >= 0; i--) {
        downheapify(i);
      }
    }
    
    // Detailed discussion on HEAP, take a look to understand well. - https://www.pepcoding.com/resources/online-java-foundation/hashmap-and-heap/priority_queue_using_heap/topic

    public void add(int val) {
      // write your code here
      data.add(val);
      upheapify(data.size() - 1);
    }
    
    private void upheapify(int child_index) {
        if(child_index == 0) {
            return;
        }
        
        int parent_index = (child_index-1)/2;
        
        if(data.get(parent_index) > data.get(child_index)) {
            swap(parent_index, child_index);
            upheapify(parent_index);
        }
    }
    
    private void swap(int pi, int ci) {
        int p = data.get(pi);
        int c = data.get(ci);
        
        data.set(pi, c);
        data.set(ci, p);
    }

    public int remove() {
      // write your code here
      if(this.size() == 0) {
          System.out.println("Underflow");
          return -1;
      }
      
      swap(0, data.size() - 1);
      int val = data.remove(data.size() - 1);
      downheapify(0);
      return val;
    }
    
    private void downheapify(int pi) {
        int min = pi;
        
        int li = 2*pi + 1;
        if(li < data.size() && data.get(li) < data.get(min)) {
            min = li;
        }
        
        int ri = 2*pi + 2;
        if(ri < data.size() && data.get(ri) < data.get(min)) {
            min = ri;
        }
        
        if(pi != min) {
            swap(pi, min);
            downheapify(min);
        }
    }

    public int peek() {
      // write your code here
      if(this.size() == 0) {
          System.out.println("Underflow");
          return -1;
      }
      
      return data.get(0);
    }

    public int size() {
      // write your code here
      return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}
