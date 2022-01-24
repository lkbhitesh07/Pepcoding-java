// First method - but complexity is O(n^3)

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < prices.length; i++){
            prices[i] = scn.nextInt();
        }
        int a = scn.nextInt();
        
        int[][] dp = new int[a+1][n];
        
        for(int i = 1; i <= a; i++){
            for(int j = 1; j < prices.length; j++){
                int max = dp[i][j-1];
                for(int k = 0; k < j; k++){
                    int val = prices[j] - prices[k];
                    if(dp[i-1][k] + val > max){
                       max = dp[i-1][k] + val; 
                    }
                }
                
                dp[i][j] = max;
            }
        }
        
        System.out.println(dp[a][n-1]);
    }

}


// More optimized approach - O(n^2)

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < prices.length; i++){
            prices[i] = scn.nextInt();
        }
        int a = scn.nextInt();
        
        int[][] dp = new int[a+1][n];
        
        for(int i = 1; i <= a; i++){
            int max = Integer.MIN_VALUE;
            for(int j = 1; j < prices.length; j++){
                if(dp[i-1][j-1] - prices[j-1] > max){
                    max = dp[i-1][j-1] - prices[j-1];
                }
                
                if(max + prices[j] > dp[i][j-1]){
                    dp[i][j] = max + prices[j];
                }
                else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        
        System.out.println(dp[a][n-1]);
    }

}
