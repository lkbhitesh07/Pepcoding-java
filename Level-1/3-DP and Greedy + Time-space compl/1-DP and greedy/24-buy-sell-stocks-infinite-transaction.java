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
        
        int sell = 0;
        int buy = 0;
        int profit = 0;
        
        for(int i = 1; i < prices.length; i++){
            if(prices[i] >= prices[i-1]){
                sell++;
            }
            else{
                profit += prices[sell] - prices[buy];
                sell = buy = i;
            }
        }
        profit += prices[sell] - prices[buy];
        System.out.println(profit);
    }

}
