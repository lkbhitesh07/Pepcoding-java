import java.io.*;
import java.util.*;

class subArray{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    int[] a = new int[n];
    for(int i = 0; i < a.length; i++){
        int ele = scn.nextInt();
        a[i] = ele;
    }
    for(int i = 0; i < a.length; i++){
        for(int j = i; j < a.length; j++){
            for(int k = i; k <= j; k++){
                System.out.print(a[k] + "\t");
            }
            System.out.println();
        }
    }
 }

}
