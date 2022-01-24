import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    long oldBuldings = 1;
    long oldSpaces = 1;
    
    for(int i = 2; i <= n; i++){
        long newSpaces = oldBuldings + oldSpaces;
        long newBuildings = oldSpaces;
        
        oldSpaces = newSpaces;
        oldBuldings = newBuildings;
    }
    
    long total = oldSpaces + oldBuldings;
    
    total = total * total;
    
    System.out.println(total);
 }

}
