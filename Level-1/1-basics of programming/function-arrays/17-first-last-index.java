import java.io.*;
import java.util.*;

class firstLastIndex{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    int[] a = new int[n];
    
    for(int i = 0; i <n; i++){
        int value = scn.nextInt();
        a[i] = value;
    }
    
    int data = scn.nextInt();
    
    int lo = 0;
    int hi = a.length-1;
    int fi = -1;
    
    while(lo<=hi){
        int m = (lo+hi)/2;
        
        if(data>a[m]){
            lo = m+1;
        }
        else if(data<a[m]){
            hi = m - 1;
        }
        else{
            fi = m;
            hi = m-1;
        }
    }
    System.out.println(fi);
    
    lo = 0;
    hi = a.length-1;
    int li = -1;
    
    while(lo<=hi){
        int m = (lo+hi)/2;
        
        if(data>a[m]){
            lo = m+1;
        }
        else if(data<a[m]){
            hi = m - 1;
        }
        else{
            li = m;
            lo = m+1;
        }
    }
    System.out.println(li);
 }

}
