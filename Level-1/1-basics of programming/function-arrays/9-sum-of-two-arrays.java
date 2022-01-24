import java.io.*;
import java.util.*;

class sumOf2Array{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in); //To get input from system
    
    int num1 = scn.nextInt();
    int[] arr1 = new int[num1];
    for(int i = 0; i < arr1.length; i++){
        arr1[i] = scn.nextInt();
    }
    
    int num2 = scn.nextInt();
    int[] arr2 = new int[num2];
    for(int i = 0; i < arr2.length; i++){
        arr2[i] = scn.nextInt();
    }
    
    int[] sum = new int[num1 > num2 ? num1 : num2]; //Length of array in which sum has to be stored
    
    int i = arr1.length - 1;
    int j = arr2.length - 1;
    int k = sum.length - 1;
    int carry = 0;
    
    while(k>=0){
        int d = carry;
        
        if(i>=0){
            d += arr1[i];
        }
        
        if(j>=0){
            d += arr2[j];
        }
        
        carry = d / 10;
        d = d % 10;
        
        sum[k] = d;
        
        i--;
        j--;
        k--;
    }
    
    if(carry != 0){
        System.out.println(carry);
    }
    for(int val: sum){
        System.out.println(val);
    }
 }

}
