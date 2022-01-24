import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int res = power(x, n);
        System.out.println(res);
    }

    public static int power(int x, int n){
        if(n == 0){
            return 1;
        }
        
        int pnb2 = power(x, n/2);
        int pn = pnb2 * pnb2;
        if(n%2==1){
            pn *= x;
        }
        return pn;
    }

}
// Here the O(n) is log(n) due to the pattern of GP, as we are doing half everytime.
