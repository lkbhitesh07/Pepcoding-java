import java.io.*;
import java.util.*;

public class Main {

    public static class Edge {
        int curr;
        int nbr;
        
        public Edge(int curr, int nbr) {
            this.curr = curr;
            this.nbr = nbr;
        }
    }
    

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());

    // write your code here
    ArrayList<Edge>[] graph = new ArrayList[n];
    
    for(int v = 0; v < n; v++) {
        graph[v] = new ArrayList<>();
    }
    
    for(int e = 0; e < k; e++) {
        String line = br.readLine();
        String[] parts = line.split(" ");
        
        int v1 = Integer.parseInt(parts[0]);
        int v2 = Integer.parseInt(parts[1]);
        
        graph[v1].add(new Edge(v1, v2));
        graph[v2].add(new Edge(v2, v1));
    }
    
    ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
    boolean[] visited = new boolean[n];
    for(int i = 0; i < n; i++) {
        if(visited[i] == false) {
            ArrayList<Integer> comp = new ArrayList<>();
            hasTree(graph, i, comp, visited);
            comps.add(comp);
        }
    }
    
    int count = 0;
    for(int i = 0; i < comps.size(); i++) {
        for(int j = i+1; j < comps.size(); j++) {
            count += comps.get(i).size() * comps.get(j).size();
        }
    }
    
    System.out.println(count);
  }
  
  public static void hasTree(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean[] visited) {
      
      visited[src] = true;
      comp.add(src);
      for(Edge e: graph[src]) {
          if(visited[e.nbr] == false) {
              hasTree(graph, e.nbr, comp, visited);
          }
      }
  }

}
