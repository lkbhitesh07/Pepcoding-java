//First method
//It have complexity of n3, so we will try to calculate least and secondleast parallely
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        int[][] arr = new int[n][k];
        
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        int[][] dp = new int[n][k];
        
        for(int j = 0; j < arr[0].length; j++){
            dp[0][j] = arr[0][j];
        }
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                
                int min = Integer.MAX_VALUE;
                for(int l = 0; l < dp[0].length; l++){
                    if(l != j){
                        if(dp[i-1][l] < min){
                            min = dp[i-1][l];
                        }
                    }
                }
                
                dp[i][j] = arr[i][j] + min;
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int l = 0; l < dp[0].length; l++){
            if(dp[n-1][l] < min){
                min = dp[n-1][l];
            }
        }
        
        System.out.println(min);
    }
}




// Second method


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        int[][] arr = new int[n][k];
        
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        int[][] dp = new int[n][k];
        
        int least = Integer.MAX_VALUE;
        int Secondleast = Integer.MAX_VALUE;
        
        for(int j = 0; j < arr[0].length; j++){
            dp[0][j] = arr[0][j];
            if(arr[0][j] <= least){
                Secondleast = least;
                least = arr[0][j];
            }
            else if(arr[0][j] <= Secondleast){
                Secondleast = arr[0][j];
            }
        }
        
        for(int i = 1; i < dp.length; i++){
            int newLeast = Integer.MAX_VALUE;
            int newSecondleast = Integer.MAX_VALUE;
            for(int j = 0; j < dp[0].length; j++){
                
                if(least == dp[i-1][j]){
                    dp[i][j] = Secondleast + arr[i][j];
                }
                else{
                    dp[i][j] = least + arr[i][j];
                }
                
                if(dp[i][j] <= newLeast){
                    newSecondleast = newLeast;
                    newLeast = dp[i][j];
                }
                else if(dp[i][j] <= newSecondleast){
                    newSecondleast = dp[i][j];
                }
            }
            
            
            least = newLeast;
            Secondleast = newSecondleast;
            
        }
        
        System.out.println(least);
    }
}
