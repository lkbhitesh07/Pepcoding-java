import java.io.*;
import java.util.*;

// important

public class Main {

  public static class HashMap<K, V> {
    private class HMNode {
      K key;
      V value;

      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size; // n
    private LinkedList<HMNode>[] buckets; // N = buckets.length

    public HashMap() {
      initbuckets(4);
      size = 0;
    }

    private void initbuckets(int N) {
      buckets = new LinkedList[N];
      for (int bi = 0; bi < buckets.length; bi++) {
        buckets[bi] = new LinkedList<>();
      }
    }

    public void put(K key, V value) throws Exception {
      // write your code here
      int bucket_index = hashFun(key);
      int data_index = getIndexOfDataFromBucket(key, bucket_index);
      
      if(data_index != -1) {
          HMNode node = buckets[bucket_index].get(data_index);
          node.value = value;
      } else {
          HMNode node = new HMNode(key, value);
          buckets[bucket_index].add(node);
          size++;
      }
      
      double lamda = size*1.0 / buckets.length;
      if(lamda > 2.0) {
          rehash();
      }
    }
    
    private int hashFun(K key) {
        int hc = key.hashCode();
        return Math.abs(hc) % buckets.length;
    }
    
    private int getIndexOfDataFromBucket(K key, int bi) {
        int di = 0;
        for(HMNode node: buckets[bi]) {
            if(node.key.equals(key)) {
                return di;
            }
            di++;
        }
        
        return -1;
    }
    
    private void rehash() throws Exception {
        LinkedList<HMNode>[] old_buc = buckets;
        initbuckets(old_buc.length * 2);
        size = 0;
        
        for(int bi = 0; bi < old_buc.length; bi++) {
            for(HMNode node: old_buc[bi]) {
                put(node.key, node.value);
            }
        }
    }

    public V get(K key) throws Exception {
      // write your code here
      int bucket_index = hashFun(key);
      int data_index = getIndexOfDataFromBucket(key, bucket_index);
      
      if(data_index != -1) {
          HMNode node = buckets[bucket_index].get(data_index);
          return node.value;
      } else {
          return null;
      }
    }

    public boolean containsKey(K key) {
      // write your code here
      int bucket_index = hashFun(key);
      int data_index = getIndexOfDataFromBucket(key, bucket_index);
      
      if(data_index != -1) {
          return true;
      } else {
          return false;
      }
    }

    public V remove(K key) throws Exception {
      // write your code here
      int bucket_index = hashFun(key);
      int data_index = getIndexOfDataFromBucket(key, bucket_index);
      
      if(data_index != -1) {
          HMNode node = buckets[bucket_index].remove(data_index);
          size--;
          return node.value;
      } else {
          return null;
      }
    }

    public ArrayList<K> keyset() throws Exception {
      // write your code here
      ArrayList<K> keys = new ArrayList<>();
      for(int bi = 0; bi < buckets.length; bi++) {
          for(HMNode node: buckets[bi]) {
              keys.add(node.key);
          }
      }
      
      return keys;
    }

    public int size() {
      // write your code here
      return size;
    }

   public void display() {
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print( node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
  }
}

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);
      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));
      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));
      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));
      } else if (str.startsWith("size")) {
        System.out.println(map.size());
      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());
      } else if (str.startsWith("display")) {
        map.display();
      }
      str = br.readLine();
    }
  }
}
