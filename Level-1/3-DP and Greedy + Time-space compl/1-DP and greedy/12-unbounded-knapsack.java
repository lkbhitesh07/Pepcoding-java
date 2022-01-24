	import java.io.*;
	import java.util.*;

	public class Main {

	    public static void main(String[] args) throws Exception {
            Scanner scn = new Scanner(System.in);
            
            int n = scn.nextInt();
            
            int[] vals = new int[n];
            for(int val = 0; val < vals.length; val++){
                vals[val] = scn.nextInt();
            }
            
            int[] wts = new int[n];
            for(int wt = 0; wt < wts.length; wt++){
                wts[wt] = scn.nextInt();
            }
            
            int cap = scn.nextInt();
            
            int[] dp = new int[cap+1];
            
            dp[0] = 0;
            
            for(int bagc = 1; bagc <= cap; bagc++){
                
                int max = 0;
                
                for(int i = 0; i < n; i++){
                    
                    if(wts[i] <= bagc){
                        int remBagc = bagc - wts[i];
                        int remBagv = dp[remBagc];
                        int totalBagv = remBagv + vals[i];
                        
                        if(totalBagv > max){
                            max = totalBagv;
                        }
                    }
                }
                
                dp[bagc] = max;
            }
            
            System.out.println(dp[cap]);
	    }
	}
