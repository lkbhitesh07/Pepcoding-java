import java.io.*;
import java.util.*;

class barChart{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    
    int num = scn.nextInt();
    int[] arr = new int[num];
    for(int i = 0; i < arr.length; i++){
        arr[i] = scn.nextInt();
    }
    
    int max = arr[0];
    for(int i = 0; i < arr.length; i++){
        if(arr[i]>max){
            max = arr[i];
        }
    }
    
    for(int floor = max; floor >= 1; floor--){
        for(int i = 0; i < arr.length; i++){
            if(arr[i]>=floor){
                System.out.print("*\t");
            }
            else{
                System.out.print("\t");
            }
        }
        System.out.println();
    }
}

}


// 				*	
// 				*	
// 				*	*
// 				*	*
// *			*	*	
// *			*	*	
// *	*		*	*

// 3	1	0	7	5
