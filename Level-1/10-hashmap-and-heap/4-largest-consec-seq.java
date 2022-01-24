import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
        arr[i] = scn.nextInt();
    }

    HashMap<Integer, Boolean> hm = new HashMap<>();

    for(int val: arr) {
        hm.put(val, true); //every element is a begining
    }

    for(int val: arr) {
        if(hm.containsKey(val-1)) {
            hm.put(val, false);
        }
    }

    int main_len = 0;
    int start_point = 0;
    for(int val: arr) {
        if(hm.get(val) == true) {
            int curr_len = 1;
            int curr_start_point = val;

            while(hm.containsKey(val+curr_len)) {
                curr_len++;
            }

            if (curr_len > main_len) {
                main_len = curr_len;
                start_point = curr_start_point;
            }
        }
    }

    for(int i = 0; i < main_len; i++) {
        System.out.println(start_point + i);
    }
 }

}
