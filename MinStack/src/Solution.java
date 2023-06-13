import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '{' ||s.charAt(i) =='(' ){
                stack.push(s.charAt(i));
            }else {
                if (stack.empty()){
                    return false;
                }
                char ch = stack.peek();
                if (ch == '(' && s.charAt(i)==')' || ch == '{' && s.charAt(i)=='}'|| ch == '[' && s.charAt(i)==']'){
                    stack.pop();
                    return true;
                }else {
                    return false;
                }
            }
        }
        if (!stack.empty()){
            return false;
        }
        return true;
    }
}