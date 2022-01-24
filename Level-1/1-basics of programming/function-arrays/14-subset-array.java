// Imp que - hua nhi tha, bhdiya trick h
import java.io.*;
import java.util.*;

class subsetArray{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    int[] a = new int[n];
    for(int i = 0; i < a.length; i++){
        int num = scn.nextInt();
        a[i] = num;
    }
    
    int limit = (int)Math.pow(2, n);
    for(int i = 0; i < limit; i++){
        int temp = i;
        String res = "";
        for(int j = a.length-1; j >= 0; j--){
            int r = temp%2;
            temp = temp/2;
            
            if(r==0){
                res = "-\t" + res;
            }
            else{
                res = a[j] + "\t" + res;
            }
        }
        System.out.println(res);
    }
 }

}

            // -	-	-	
            // -	-	30	
            // -	20	-	
            // -	20	30	
            // 10	-	-	
            // 10	-	30	
            // 10	20	-	
            // 10	20	30	
