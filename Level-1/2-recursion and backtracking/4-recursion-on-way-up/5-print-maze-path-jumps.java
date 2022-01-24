import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        printMazePaths(1, 1, n, m, "");
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if(sr == dr && sc == dc){
            System.out.println(psf);
            return;
        }
        
        for(int mp = 1; mp <= dc - sc; mp++){
            printMazePaths(sr, sc + mp, dr, dc, psf + "h" + mp);
        }
        
        for(int mp = 1; mp <= dr - sr; mp++){
            printMazePaths(sr + mp, sc, dr, dc, psf + "v" + mp);
        }
        
        for(int mp = 1; mp <= dc - sc && mp <= dr - sr; mp++){
            printMazePaths(sr + mp, sc + mp, dr, dc, psf + "d" + mp);
        }
    }

}
