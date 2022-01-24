import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[][] a = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                a[i][j] = scn.nextInt();
            }
        }
        
        int minr = 0;
        int maxr = a.length-1;
        int minc = 0;
        int maxc = a[0].length-1;
        
        for(int row = 0; row < a.length; row++){
            for(int i = minr, j = minc; i <= maxr && j <= maxc; i++, j++){
                System.out.println(a[i][j]);
            }
            minc++;
            maxr--;
        }
    }

}



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[][] a = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                a[i][j] = scn.nextInt();
            }
        }
        
        for(int g = 0; g < a.length; g++){ //gap between i&j in start
        	for(int i = 0, j = g; j < a.length; i++, j++){
        		System.out.println(a[i][j]);
        	}
        }
    }

}
