import java.io.*;
import java.util.*;

class ceilFloor{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] a = new int[n];
    
    for(int i = 0; i < n; i++){
        int val = scn.nextInt();
        a[i] = val;
    }
    
    int data = scn.nextInt();
    
    int lo = 0;
    int hi = a.length-1;
    int ceil = 0;
    int floor = 0;
    
    while(lo <= hi){
        int m = (lo+hi)/2;
        
        if(data > a[m]){
            lo = m + 1;
            ceil = a[m];
        }
        else if(data < a[m]){
            hi = m - 1;
            floor = a[m];
        }
        else{
            ceil = a[m];
            floor = a[m];
            break;
        }
    }
    System.out.println(floor);
    System.out.println(ceil);
 }

}
