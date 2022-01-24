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
        
        int fee = scn.nextInt();
        
        int oldBoughtProfit = -prices[0];
        int oldSellProfit = 0;
        
        for(int i = 1; i < prices.length; i++){
            int newBoughtProfit = 0;
            int newSellProfit = 0;
            
            if(oldSellProfit - prices[i] > oldBoughtProfit){
                newBoughtProfit = oldSellProfit - prices[i];
            }
            else{
                newBoughtProfit = oldBoughtProfit;
            }
            
            if(oldBoughtProfit + prices[i] - fee > oldSellProfit){
                newSellProfit = oldBoughtProfit + prices[i] - fee;
            }
            else{
                newSellProfit = oldSellProfit;
            }
            
            oldSellProfit = newSellProfit;
            oldBoughtProfit = newBoughtProfit;
        }
        
        System.out.println(oldSellProfit);
    }

}
