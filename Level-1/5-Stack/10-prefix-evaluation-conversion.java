import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<Integer> value = new Stack<>();
    Stack<String> in = new Stack<>();
    Stack<String> post = new Stack<>();
    
    for(int i = exp.length() - 1; i >= 0; i--){
        char ch = exp.charAt(i);
        
        if(Character.isDigit(ch)){
            value.push(ch - '0');
            post.push(ch + "");
            in.push(ch + "");
        }
        else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            // post conversion
            String post_val1 = post.pop();
            String post_val2 = post.pop();
            
            String post_val = post_val1 + post_val2 + ch;
            post.push(post_val);
            
            //infix conversoin
            String in_val1 = in.pop();
            String in_val2 = in.pop();
            
            String in_val = "(" +  in_val1 + ch + in_val2 + ")";
            in.push(in_val);
            
            //value stack
            int val1 = value.pop();
            int val2 = value.pop();
            
            int val = operation(ch, val1, val2);
            
            value.push(val);
        }
    }
    
    System.out.println(value.peek());
    System.out.println(in.peek());
    System.out.println(post.peek());
 }
 
public static int operation(char ch, int val1, int val2){
    if(ch == '+'){
        return val1 + val2;
    }
    if(ch == '-'){
        return val1 - val2;
    }
    if(ch == '*'){
        return val1 * val2;
    }
    else{
        return val1 / val2;
    }
}
}
