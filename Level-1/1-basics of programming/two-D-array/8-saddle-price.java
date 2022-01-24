import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[][] a = new int[n][n];
        
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length; j++){
                a[i][j] = scn.nextInt();
            }
        }
        
        for(int i = 0; i < a.length; i++){
            int svj = 0;
            for(int j = 1; j < a[0].length; j++){
                if(a[i][svj] > a[i][j]){
                    svj = j;
                }
            }
            
            boolean flag = true;
            
            for(int k = 0; k < a.length; k++){
                if(a[i][svj] < a[k][svj]){
                    flag = false;
                    break;
                }
            }
            
            if(flag==true){
                System.out.println(a[i][svj]);
                return;
            }
        }
        
        System.out.print("Invalid input");
    }

}
