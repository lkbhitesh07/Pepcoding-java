import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] dp = new int[n+1];
        dp[1] = 1; //1 way to put the single tile
        dp[2] = 2; //2 ways we have if we have to put tiles in 2*2 floor - horizontal and vertical.
        
        for(int j = 3; j < dp.length; j++){
            dp[j] = dp[j-1] + dp[j-2];
        }
        System.out.println(dp[n]);
    }
}
