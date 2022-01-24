import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] vals = new int[n];
        int[] wts = new int[n];
        
        for(int i = 0; i < vals.length; i++){
            vals[i] = scn.nextInt();
        }
        for(int i = 0; i < wts.length; i++){
            wts[i] = scn.nextInt();
        }
        
        int cap = scn.nextInt();
        
        int[][] dp = new int[n+1][cap+1];
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j >= wts[i-1]){ //If player is going to bat.
                    int rCap = j - wts[i-1];
                    if(vals[i-1] + dp[i-1][rCap] > dp[i-1][j]){ // if the value of (player bats + remaining run) is greater
                        dp[i][j] = vals[i-1] + dp[i-1][rCap]; 
                    }
                    else{ // If not going to bat
                        dp[i][j] = dp[i-1][j];
                    }
                }
                else{ // If cannot to bat
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        System.out.print(dp[n][cap]);
    }
}