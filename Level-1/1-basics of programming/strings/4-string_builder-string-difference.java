import java.util.*;

public class Main{

public static void main(String[] args){
	int n = 10000;
	
	long start_string = System.currentTimeMillis();
	String s = "";
	for(int i = 0; i < n; i++){
		s += i;
	}
	long end_string = System.currentTimeMillis();
	long duration_string = end_string - start_string;
	System.out.println(duration_string);
	
	
	long start_subString = System.currentTimeMillis();
	StringBuilder sb = new StringBuilder();
	for(int i = 0; i < n; i++){
		sb.append(i);
	}
	long end_subString = System.currentTimeMillis();
	long duration_subString = end_subString - start_subString;
	System.out.println(duration_subString);
	
}
}
