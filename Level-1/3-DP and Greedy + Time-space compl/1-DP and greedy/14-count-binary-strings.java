import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    // Method 1st
    
    // int[] onesArray = new int[n+1];
    // int[] zeroesArray = new int[n+1];
    
    // onesArray[1] = 1;
    // zeroesArray[1] = 1;
    
    // for(int i = 2; i <= n; i++){
    //     onesArray[i] = onesArray[i-1] + zeroesArray[i-1];
    //     zeroesArray[i] = onesArray[i-1];
    // }
    
    // System.out.println(onesArray[n] + zeroesArray[n]);
    
    
    // Method 2
    
    int oldOnesCount = 1;
    int oldZeroesCount = 1;
    
    for(int i = 2; i <= n; i++){
        int newOnesCount = oldOnesCount + oldZeroesCount;
        int newZeroesCount = oldOnesCount;
        
        oldOnesCount = newOnesCount;
        oldZeroesCount = newZeroesCount;
    }
    
    System.out.println(oldOnesCount + oldZeroesCount);
 }

}
