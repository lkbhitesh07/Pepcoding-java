import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);

    int n1 = scn.nextInt();
    int[] arr1 = new int[n1];
    for(int i = 0; i < n1; i++) {
        arr1[i] = scn.nextInt();
    }

    int n2 = scn.nextInt();
    int[] arr2 = new int[n2];
    for(int i = 0; i < n2; i++) {
        arr2[i] = scn.nextInt();
    }

    HashMap<Integer, Integer> hm1 = new HashMap<>();

    for(int ele: arr1) {
        if (hm1.containsKey(ele)) {
            int of = hm1.get(ele);
            int nf = of+1;
            hm1.put(ele, nf);
        } else {
            hm1.put(ele, 1);
        }
    }

    for(int ele: arr2) {
        if(hm1.containsKey(ele)) {
            int freq = hm1.get(ele);
            if(freq != 0) {
                System.out.println(ele);
                hm1.put(ele, freq-1);
            }
        }
    }
 }

}
