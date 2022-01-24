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
        
        int maxTillNow = 0;
        int least = prices[0];
        int[] dpLeft = new int[prices.length];
        
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < least){
                least = prices[i];
            }
            maxTillNow = prices[i] - least;
            if(maxTillNow > dpLeft[i-1]){
                dpLeft[i] = maxTillNow;
            }
            else{
                dpLeft[i] = dpLeft[i-1];
            }
        }
        
        int maxTillNowRight = 0;
        int MaxValue = prices[prices.length-1];
        int[] dpRight = new int[prices.length];
        
        for(int i = prices.length-2; i >= 0; i--){
            if(prices[i] > MaxValue){
                MaxValue = prices[i];
            }
            maxTillNowRight = MaxValue - prices[i];
            if(maxTillNow > dpRight[i+1]){
                dpRight[i] = maxTillNowRight;
            }
            else{
                dpRight[i] = dpRight[i+1];
            }
        }
        
        int output = 0;
        for(int i = 0; i < prices.length; i++){
            if(output < dpLeft[i] + dpRight[i]){
                output = dpLeft[i] + dpRight[i];
            }
        }
        
        System.out.println(output);
    }

}
