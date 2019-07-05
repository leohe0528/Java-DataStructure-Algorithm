package Calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CalculatorIII {
    private Map<Character, Integer> map = new HashMap<Character, Integer>(){
        {
            put('+', 1);
            put('-', 1);
            put('*', 2);
            put('/', 2);
        }
    };

    public int calculate(String s) {
        if (s == null) return 0;
        Stack<Integer> stackNum = new Stack<>();
        Stack<Character> stackOpt = new Stack<>();
        int len = s.length();
        int i = 0;
        while (i < len){
            char c = s.charAt(i);
            //skip when c is emtpy space
            if (c == ' ') i++;
                //get the whole number and push it to stackNum
            else if (Character.isDigit(c)){
                int val = 0;
                while (i < len && Character.isDigit(s.charAt(i))){
                    val = 10 * val + (s.charAt(i) - '0');
                    i++;
                }
                stackNum.push(val);
                //process when c is (, ), or operand
            }else if (c == '(' || c == ')' || map.containsKey(c)){
                process(c, stackNum, stackOpt);
                i++;
            }
        }

        while (!stackOpt.isEmpty()){
            int num2 = stackNum.pop();
            int num1 = stackNum.pop();
            char opt = stackOpt.pop();
            int res = calculate(num1, num2, opt);
            stackNum.push(res);
        }
        return stackNum.pop();
    }

    private void process(char c, Stack<Integer> stackNum, Stack<Character> stackOpt){
        if (map.containsKey(c)){
            int currWeight = map.get(c);
            while (true){
                if (stackOpt.isEmpty()) break;
                char topOpt = stackOpt.peek();
                Integer topWeight = map.get(topOpt);
                if (topWeight == null || currWeight > topWeight) break;
                int num2 = stackNum.pop();
                int num1 = stackNum.pop();
                char opt = stackOpt.pop();
                int res = calculate(num1, num2, opt);
                stackNum.push(res);
            }
            if (c == '-' && stackNum.isEmpty()) stackNum.push(0);
            else if (c == '-' && stackOpt.peek() == '(') stackNum.push(0);
            stackOpt.push(c);
        }else if (c == '(') {
            stackOpt.push(c);
        }else {
            while (!stackOpt.isEmpty() && stackOpt.peek() != '('){
                int num2 = stackNum.pop();
                int num1 = stackNum.pop();
                char opt = stackOpt.pop();
                int res = calculate(num1, num2, opt);
                stackNum.push(res);
            }
            stackOpt.pop();
        }
    }

    private int calculate(int num1, int num2, char opt){
        if (opt == '+') return num1 + num2;
        else if (opt == '-') return num1 - num2;
        else if (opt == '*') return num1 * num2;
        else return num1 / num2;
    }

    public static void main(String[] args){
        String s = "1-(-7)";
        int res = new CalculatorIII().calculate(s);
    }
}
