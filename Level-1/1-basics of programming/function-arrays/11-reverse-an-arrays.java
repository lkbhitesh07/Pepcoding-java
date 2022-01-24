import java.io.*;
import java.util.*;

class reverseArray{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + " ");
    }
    System.out.println(sb);
  }

  public static void reverse(int[] a){
    // write your code here
    int start = 0;
    int end = a.length-1;
    
    int count = 0;
    while(count<(a.length/2)){
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;
        count++;
        start++;
        end--;
    }
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    reverse(a);
    display(a);
 }

}
