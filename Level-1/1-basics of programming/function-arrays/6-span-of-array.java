import java.io.*;
import java.util.*;

class spanOfArray{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    
    int num = scn.nextInt();
    int[] arr = new int[num];
    for(int i = 0; i<arr.length; i++){
        arr[i] = scn.nextInt();
    }
    int max = arr[0];
    int min = arr[0];
    
    for(int i = 1; i<arr.length; i++){
        if(max<arr[i]){
            max = arr[i];
        }
        if(min>arr[i]){
            min = arr[i];
        }
    }
    System.out.println(max-min);
 }

}
