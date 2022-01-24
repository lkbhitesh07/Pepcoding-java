import java.io.*;
import java.util.*;

public class Main {
    
   public static class Pair implements Comparable<Pair> {
       int list_index;
       int curr_index;
       int val;
       
       Pair(int list_index, int curr_index, int val) {
           this.list_index = list_index;
           this.curr_index = curr_index;
           this.val = val;
       }
       
       public int compareTo(Pair o) {
           return this.val - o.val;
       }
   }     
    
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();

      // write your code here
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      for(int i = 0; i < lists.size(); i++) {
          int val = lists.get(i).get(0);
          Pair p = new Pair(i, 0, val);
          pq.add(p);
      }
      
      while(pq.size() > 0) {
          Pair p = pq.remove();
          rv.add(p.val);
          p.curr_index++;
          
          if(p.curr_index < lists.get(p.list_index).size()) {
              p.val = lists.get(p.list_index).get(p.curr_index);
              pq.add(p);
          }
      }

      return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}
