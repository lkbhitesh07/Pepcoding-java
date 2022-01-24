import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();    
        
        int[] dp = new int[n+1];
        
        dp[1] = 1; // If only one person than only one possibility
        dp[2] = 2; // If two person than two possibility of being single and be paired.
        
        for(int i = 3; i < dp.length; i++){
            dp[i] = dp[i-2] * (i-1) + dp[i-1]; // If the person wants to pair up and if the person wants to be single.
        }
        
        System.out.println(dp[n]);
    }

}
