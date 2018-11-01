import java.util.Stack;
/**
 * @ProjectName: Stack
 * @Package: PACKAGE_NAME
 * @ClassName:
 * @Description: 括号匹配
 * @Author: fanxx
 * @CreateDate: 2018/11/1 13:58
 * <p>Copyright: Copyright (c) 2018</p>
 */
 class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}