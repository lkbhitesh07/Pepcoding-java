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
        
        int oldBaughtPrice = -prices[0];
        int oldSellPrice = 0;
        int oldCooldownPrice = 0;
        
        for(int i = 1; i < prices.length; i++){
            int newBaughtPrice = 0;
            int newSellPrice = 0;
            int newCooldownPrice = 0;
            
            if(oldCooldownPrice - prices[i] > oldBaughtPrice){
                newBaughtPrice = oldCooldownPrice - prices[i];
            }
            else{
                newBaughtPrice = oldBaughtPrice;
            }
            
            if(oldBaughtPrice + prices[i] > oldSellPrice){
                newSellPrice = oldBaughtPrice + prices[i];
            }
            else{
                newSellPrice = oldSellPrice;
            }
            
            if(oldSellPrice > oldCooldownPrice){
                newCooldownPrice = oldSellPrice;
            }
            else{
                newCooldownPrice = oldCooldownPrice;
            }
            
            oldBaughtPrice = newBaughtPrice;
            oldSellPrice = newSellPrice;
            oldCooldownPrice = newCooldownPrice;
        }
        
        System.out.println(oldSellPrice);
    }

}
