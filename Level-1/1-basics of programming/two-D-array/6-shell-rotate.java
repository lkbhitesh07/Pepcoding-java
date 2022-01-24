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
        
        int s = scn.nextInt();
        int r = scn.nextInt();
        
        rotateShell(a, s, r);
        display(a);
    }
    
    public static void rotateShell(int[][] a, int s, int r){
        int[] oned = fillOnedFromShell(a, s);
        rotate(oned, r);
        fillShellFromOned(a, s, oned);
    }
    
    public static int[] fillOnedFromShell(int[][] a, int s){
        int minr = s-1;
        int maxr = a.length - s;
        int minc = s-1;
        int maxc = a[0].length - s;
        
        int size = 2*(maxr-minr+maxc-minc);//2*(maxr-minr+1) + 2*(maxc-minc+1) - 4
        int[] oned = new int[size];
        
        int idx = 0;
        
        //lf
        for(int i = minr, j = minc; i <= maxr; i++){
            oned[idx] = a[i][j];
            idx++;
        }
        
        //bw
        for(int i = maxr, j = minc+1; j <= maxc; j++){
            oned[idx] = a[i][j];
            idx++;
        }
        //rw
        for(int i = maxr-1, j = maxc; i >= minr; i--){
            oned[idx] = a[i][j];
            idx++;
        }
        //tw
        for(int i = minr, j = maxc-1; j >= minc+1; j--){
            oned[idx] = a[i][j];
            idx++;
        }
        
        return oned;
    }
    
    public static void fillShellFromOned(int[][] a, int s, int[] oned){
        int minr = s-1;
        int maxr = a.length - s;
        int minc = s-1;
        int maxc = a[0].length - s;
        
        int idx = 0;
        
        //lf
        for(int i = minr, j = minc; i <= maxr; i++){
            a[i][j] = oned[idx];
            idx++;
        }
        
        //bw
        for(int i = maxr, j = minc+1; j <= maxc; j++){
            a[i][j] = oned[idx];
            idx++;
        }
        //rw
        for(int i = maxr-1, j = maxc; i >= minr; i--){
            a[i][j] = oned[idx];
            idx++;
        }
        //tw
        for(int i = minr, j = maxc-1; j >= minc+1; j--){
            a[i][j] = oned[idx];
            idx++;
        }
    }
    
    public static void rotate(int[] oned, int r){
        r = r % oned.length;
        if(r<0){
            r = r+oned.length;
        }
        
        reverse(oned, 0, oned.length-r-1);
        reverse(oned, oned.length-r, oned.length-1);
        reverse(oned, 0, oned.length-1);
    }
    
    public static void reverse(int[] oned, int fi, int li){
        while(fi < li){
            int temp = oned[fi];
            oned[fi] = oned[li];
            oned[li] = temp;
            
            fi++;
            li--;
        }
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
