package base.huawei.face.string;

import java.util.Stack;

public class ZuiChangYouXiaoKuoHao {
    public static void main(String[] args) {
        longestValidParentheses(")(())))");
        "".equals("");
    }

    /**
     * 最长有效括号匹配,暴力
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        int ans = 0;
        int str1i = s.indexOf("(");
        int str2i = s.lastIndexOf(")");
        s = s.substring(str1i, str2i + 1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                if (isok(temp) && temp.length() > ans) {
                    ans = temp.length();
                }
            }
        }
        return ans;
    }

    /**
     * 括号匹配
     *
     * @param str
     * @return
     */
    public static boolean isok(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            }
            if (str.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char c = stack.peek();
                char ck = str.charAt(i);

                if (c == '(' && ck == ')') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 栈
     */
    public int longestValidParentheses1(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

}
