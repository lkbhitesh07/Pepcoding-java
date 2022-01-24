import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] a = new int[n][n];
        
        for(int i = 0; i < a[0].length; i++){
            for(int j = 0; j < a.length; j++){
                a[i][j] = scn.nextInt();
            }
        }
        // 90 degree rotate krna h to hum ise 2 parts me tod sakte h, 1st me transpose krenge and uske baad rows wise hume swap krna h.
        //Transpose
        for(int i = 0; i < a.length; i++){
            for(int j = i; j < a[0].length; j++){
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        
        // row wise swap
        for(int i = 0; i < a.length; i++){
            int fi = 0;
            int li = a[i].length - 1;
            
            while(fi < li){
                int temp = a[i][fi];
                a[i][fi] = a[i][li];
                a[i][li] = temp;
                
                li--;
                fi++;
            }
        }
        
        display(a);
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
