import java.io.*;
import java.util.*;

public class Main {
        
    public static long partitionKSubset(int n, int k) {
        // write your code here
        long[][] dp = new long[k+1][n+1];
        
        if(n < k || n == 0 || k ==0){
            return 0;
        }
        
        for(int teams = 1; teams <= k; teams++){
            for(int person = 1; person <= n; person++){
                if(person < teams){
                    dp[teams][person] = 0;
                }
                else if(person == teams){
                    dp[teams][person] = 1;
                }
                else{
                    dp[teams][person] = teams * dp[teams][person-1] + dp[teams-1][person-1];
                }
            }
        }
        return dp[k][n];
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        long res = partitionKSubset(n, k);
        System.out.println(res);
    }
}
