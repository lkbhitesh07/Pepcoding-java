import java.io.*;
import java.util.*;

public class Main {
    
    public static boolean isPalandrome(String ss){
        int start = 0;
        int last = ss.length()-1;
        
        while(start<=last){
            char c1 = ss.charAt(start);
            char c2 = ss.charAt(last);
            if(c1!=c2){
                return false;
            }
            else{
                start++;
                last--;
            }
        }
        return true;
    }

	public static void solution(String str){
		//write your code here
		for(int i = 0; i < str.length(); i++){
		    for(int j = i+1; j <= str.length(); j++){
		        String ss = str.substring(i, j);
		        if(isPalandrome(ss)==true){
		            System.out.println(ss);
		        }
		    }
		}
		
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

}
