package ArrayAndString;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveBrackets {
    public String removeBrackets(String s){
        Stack<Character> optr = new Stack<>();
        Stack<Character> chars = new Stack<>();
        boolean flag = false;
        int i = 0;
        while (i < s.length()){
            char c = s.charAt(i);
            if (c == '+') optr.push((!flag) ? '+' : '-');
            else if (c == '-') optr.push(!flag ? '-' : '+');
            else if (c == '('){
                if (!optr.isEmpty() && optr.peek() == '-') flag = true;
            }else if (c == ')'){
                flag = false;
            }else {
                chars.push(c);
            }
            i++;
        }
        List<Character> res = new ArrayList<>();
        while (!optr.isEmpty() && !chars.isEmpty()){
            res.add(0, chars.pop());
            res.add(0, optr.pop());
        }
        if (!optr.isEmpty()) res.add(0, optr.pop());
        return res.toString();
    }

    public static void main(String[] args){
        String s = "-(a+b)+c-(d-e)";
        String s1 = "-a+b-c+d";
        String s2 = "(-a-b+c-(a+d)+(a+d))";
        String res = new RemoveBrackets().removeBrackets(s2);
        System.out.println(res);
    }
}
