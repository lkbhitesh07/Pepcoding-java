import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    
    Stack<String> pre = new Stack<>();
    Stack<String> post = new Stack<>();
    Stack<Character> opt = new Stack<>();
    
    for(int i = 0; i < exp.length(); i++){
        char ch = exp.charAt(i);
        
        if(ch == '('){
            opt.push(ch);
        }
        else if(ch == ')'){
            while (opt.size() > 0 && opt.peek() != '(') {
                
              String val2pre = pre.pop();
              String val1pre = pre.pop();
              
              String val2post = post.pop();
              String val1post = post.pop();
              
              char op = opt.pop();
    
              String pre_val = op + val1pre + val2pre;
              pre.push(pre_val);
              
              String post_val = val1post + val2post + op;
              post.push(post_val);
            }

            opt.pop();
        }
        else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            while (opt.size() > 0 && opt.peek() != '(' && 
                precedence(ch) <= precedence(opt.peek())) {
                
              String val2pre = pre.pop();
              String val1pre = pre.pop();
              
              String val2post = post.pop();
              String val1post = post.pop();
              
              char op = opt.pop();
    
              String pre_val = op + val1pre + val2pre;
              pre.push(pre_val);
              
              String post_val = val1post + val2post + op;
              post.push(post_val);
            }
    
            opt.push(ch);
        }
        else{
            pre.push(ch + "");
            post.push(ch + "");
        }
    }
    
    while (opt.size() > 0) {
      String val2pre = pre.pop();
      String val1pre = pre.pop();
      
      String val2post = post.pop();
      String val1post = post.pop();
      
      char op = opt.pop();

      String pre_val = op + val1pre + val2pre;
      pre.push(pre_val);
      
      String post_val = val1post + val2post + op;
      post.push(post_val);
    }
    
    String post_val = post.pop();
    System.out.println(post_val);
    
    String pre_val = pre.pop();
    System.out.println(pre_val);
    
 }
 
 public static int precedence(char op){
    if(op == '+'){
      return 1;
    } else if(op == '-'){
      return 1;
    } else if(op == '*'){
      return 2;
    } else if(op == '/') {
      return 2;
    }
    else{
        return 0;
    }
  }
}
