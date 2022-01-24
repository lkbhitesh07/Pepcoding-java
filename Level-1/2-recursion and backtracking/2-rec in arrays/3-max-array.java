import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        
        int res = maxOfArray(arr, 0);
        System.out.println(res);
    }

    public static int maxOfArray(int[] arr, int idx){
        if(idx == arr.length){
            return arr[idx-1];
        }
        
        int tempmax = maxOfArray(arr, idx+1);
        if(tempmax<arr[idx]){
            return arr[idx];
        }
        else{
            return tempmax;
        }
    }

}
