import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      // write your code here
      
      // Concept of Minimum Spanning Tree -> Prims algorithm, covers all the vertices with minimum wt
      
      // Difference between Dijkstra and Prims - In dijkstra we were comparing in total wt as we are moving further but in prims we calculate or compare wt on indivisual basis means the indivisual edges.
      
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      boolean[] visited = new boolean[vtces];
      
      pq.add(new Pair(0, -1, 0));
      
      while(pq.size() > 0) {
          Pair rem = pq.remove();
          
          if(visited[rem.vtces] == true) {
              continue;
          }
          
          visited[rem.vtces] = true;
          
          if(rem.acq_vtces != -1) { // we don't want to print the first one as we assume the edge is imaginary.
              System.out.println("[" + rem.vtces + "-" + rem.acq_vtces + "@" + rem.wt + "]");
          }
          
          for(Edge e: graph[rem.vtces]) {
              if(visited[e.nbr] == false) {
                  pq.add(new Pair(e.nbr, rem.vtces, e.wt));
              }
          }
      }
   }
   
   public static class Pair implements Comparable<Pair> {
       int vtces; //konsi vert par ho
       int acq_vtces; // konsi vert se aaey ho
       int wt; // jaha se aaey ho aur jaha par ho uski edge ka wt kya hai
       
       public Pair(int vtces, int acq_vtces, int wt) {
           this.vtces = vtces;
           this.acq_vtces = acq_vtces;
           this.wt = wt;
       }
       
       public int compareTo(Pair o) {
           return this.wt - o.wt;
       }
   }

}
