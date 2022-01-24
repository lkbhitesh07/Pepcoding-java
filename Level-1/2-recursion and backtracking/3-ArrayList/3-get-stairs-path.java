//good question and important
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> ans = getStairPaths(n);
        System.out.println(ans);
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n==0){
            ArrayList<String> bpaths = new ArrayList<>();
            bpaths.add("");
            return bpaths;
        }
        else if(n<0){
            ArrayList<String> bpaths = new ArrayList<>();
            return bpaths;
        }
        
        ArrayList<String> paths1 = getStairPaths(n-1);
        ArrayList<String> paths2 = getStairPaths(n-2);
        ArrayList<String> paths3 = getStairPaths(n-3);
        
        ArrayList<String> paths = new ArrayList<>();
        
        for(String str: paths1){
            paths.add(1 + str);
        }
        
        for(String str: paths2){
            paths.add(2 + str);
        }
        
        for(String str: paths3){
            paths.add(3 + str);
        }
        
        return paths;
    }

}
