import java.io.*;
import java.util.*;

class CountStairPath {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ans = countPathsMemoization(n, new int[n + 1]);
        System.out.println(ans);
    }
    
    public static int countPathsMemoization(int n, int[] qb){
        if(n == 0){
            return 1;
        }
        else if(n < 0){
            return 0;
        }
        
        if(qb[n] != 0){
            return qb[n];
        }
        
        int nm1 = countPathsMemoization(n - 1, qb);
        int nm2 = countPathsMemoization(n - 2, qb);
        int nm3 = countPathsMemoization(n - 3, qb);
        int cp = nm1 + nm2 + nm3;
        
        qb[n] = cp;
        return cp;
    }

}
