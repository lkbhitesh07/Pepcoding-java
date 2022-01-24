import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<Integer> operands = new Stack<>();
    Stack<Character> operators = new Stack<>();

    for (int i = 0; i < exp.length(); i++) {
      char ch = exp.charAt(i);

      if (ch == '(') {
        operators.push(ch);
      } else if (Character.isDigit(ch)) {
        operands.push(ch - '0');
      } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
        while (operators.size() > 0 && operators.peek() != '(' && 
               precedence(ch) <= precedence(operators.peek())) {
          int val2 = operands.pop();
          int val1 = operands.pop();
          char op = operators.pop();

          int opval = operation(val1, val2, op);
          operands.push(opval);
        }

        operators.push(ch);
      } else if (ch == ')') {
        while (operators.size() > 0 && operators.peek() != '(') {
          int val2 = operands.pop();
          int val1 = operands.pop();
          char op = operators.pop();

          int opval = operation(val1, val2, op);
          operands.push(opval);
        }

        if (operators.size() > 0) {
          operators.pop();
        }
      }
    }

    while (operators.size() > 0) {
      int val2 = operands.pop();
      int val1 = operands.pop();
      char op = operators.pop();

      int opval = operation(val1, val2, op);
      operands.push(opval);
    }

    int val = operands.pop();
    System.out.println(val);
  }

  public static int precedence(char op){
    if(op == '+'){
      return 1;
    } else if(op == '-'){
      return 1;
    } else if(op == '*'){
      return 2;
    } else {
      return 2;
    }
  }

  public static int operation(int val1, int val2, char op){
    if(op == '+'){
      return val1 + val2;
    } else if(op == '-'){
      return val1 - val2;
    } else if(op == '*'){
      return val1 * val2;
    } else {
      return val1 / val2;
    }
  }
}
















// import java.io.*;
// import java.util.*;

// public class Main{
  

// public static void main(String[] args) throws Exception {
//     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//     String exp = br.readLine();

//     // code
    
//     Stack<Character> opt = new Stack<>();
//     Stack<Integer> opd = new Stack<>();
    
//     for(int i = 0; i < exp.length(); i++){
//         char ch = exp.charAt(0);
        
//         if(ch == '('){
//             opt.push(ch);
//         }
//         else if(Character.isDigit(ch)){
//             opd.push(ch - '0');
//         }
//         else if(ch == ')'){
//             while(opt.peek() != '('){
//                 char optr = opt.pop();
//                 int v2 = opd.pop();
//                 int v1 = opd.pop();
                
//                 int val = value(optr, v1, v2);
//                 opd.push(val);
//             }
//             opt.pop();
//         }
//         else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
//             while(opt.size() > 0 && opt.peek() != ')' && precedence(ch) <= precedence(opt.peek())){
//                 char optr = opt.pop();
//                 int v2 = opd.pop();
//                 int v1 = opd.pop();
                
//                 int val = value(optr, v1, v2);
//                 opd.push(val);
//             }
//             opt.pop();
//         }
//     }
    
//     while(opt.size() != 0){
//         char optr = opt.pop();
//         int v2 = opd.pop();
//         int v1 = opd.pop();
        
//         int val = value(optr, v1, v2);
//         opd.push(val);
//     }
    
//     System.out.println(opd.peek());
//  }
 
// public static int value(char ch, int v1, int v2){
//     if (ch == '+'){
//         return v1 + v2;
//     }
//     else if (ch == '-'){
//         return v1 - v2;
//     }
//     else if (ch == '*'){
//         return v1 * v2;
//     }
//     else{
//         return v1 / v2;
//     }
// }

// public static int precedence(char ch){
//     if (ch == '+'){
//         return 1;
//     }
//     else if (ch == '-'){
//         return 1;
//     }
//     else if (ch == '*'){
//         return 2;
//     }
//     else{
//         return 2;
//     }
// }

// }
