import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<Integer> value = new Stack<>();
    Stack<String> in = new Stack<>();
    Stack<String> pre = new Stack<>();
    
    for(int i = 0; i < exp.length(); i++){
        char ch = exp.charAt(i);
        
        if(Character.isDigit(ch)){
            value.push(ch - '0');
            pre.push(ch + "");
            in.push(ch + "");
        }
        else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            // pre conversion
            String pre_val2 = pre.pop();
            String pre_val1 = pre.pop();
            
            String pre_val = ch + pre_val1 + pre_val2;
            pre.push(pre_val);
            
            //infix conversoin
            String in_val2 = in.pop();
            String in_val1 = in.pop();
            
            String in_val = "(" +  in_val1 + ch + in_val2 + ")";
            in.push(in_val);
            
            //value stack
            int val2 = value.pop();
            int val1 = value.pop();
            
            int val = operation(ch, val1, val2);
            
            value.push(val);
        }
    }
    
    System.out.println(value.peek());
    System.out.println(in.peek());
    System.out.println(pre.peek());
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
