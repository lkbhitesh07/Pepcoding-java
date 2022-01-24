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
        
        int overallPrice = 0;
        int priceTillToday = 0;
        int leastValue = Integer.MAX_VALUE;
        
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < leastValue){
                leastValue = prices[i];
            }
            
            priceTillToday = prices[i] - leastValue;
            
            if(overallPrice < priceTillToday){
                overallPrice = priceTillToday;
            }
        }
        System.out.println(overallPrice);
    }

}
