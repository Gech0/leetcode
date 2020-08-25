import java.util.Stack;

public class T20_isValid {
    public static void main(String[] args) {
        System.out.println(new T20_isValid().isValid("()[]{}"));
        System.out.println(new T20_isValid().isValid("([)]"));
        System.out.println(new T20_isValid().isValid("{[]}"));
    }
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch=='(' ||ch=='[' ||ch=='{') {
                brackets.push(ch);
                continue;
            }
            if (brackets.isEmpty()){
                return false;
            }
            char pop = brackets.pop();
            if (ch==')' && pop!='(') {
                return false;
            }
            if (ch==']' && pop!='[') {
                return false;
            }
            if (ch=='}' && pop!='{'){
                return false;
            }
        }
        return brackets.isEmpty();
    }
}
