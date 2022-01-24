import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] a = new int[n][m];
        
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length; j++){
                a[i][j] = scn.nextInt();
            }
        }
        
        int maxr = n-1;
        int minr = 0;
        int maxc = m-1;
        int minc = 0;
        
        int tn = n * m;
        int cnt = 0;
        
        while(cnt < tn){
            
            //left wall
            for(int i = minr, j = minc; i <= maxr && cnt < tn; i++){
                System.out.println(a[i][j]);
                cnt++;
            }
            minc++;
            
            //bottom wall
            for(int i = maxr, j = minc; j <= maxc && cnt < tn; j++){
                System.out.println(a[i][j]);
                cnt++;
            }
            maxr--;
            
            //right wall
            for(int i = maxr, j = maxc; i >= minr && cnt < tn; i--){
                System.out.println(a[i][j]);
                cnt++;
            }
            maxc--;
            
            //top wall
            for(int i = maxr, j = maxc; j >= minc && cnt<tn; j--){
                System.out.println(a[i][j]);
                cnt++;
            }
            minr++;
        }
    }

}
