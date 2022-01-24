import java.io.*;
import java.util.*;

class findEle{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int no_of_ele = scn.nextInt();
    int[] arr = new int[no_of_ele];
    for(int i = 0; i<arr.length; i++){
        arr[i] = scn.nextInt();
    }
    int find = scn.nextInt();
    int idx = -1;
    
    for(int i = 0; i<arr.length; i++){
        if(arr[i]==find){
            idx = i;
            break;
        }
    }
    System.out.println(idx);
 }

}
