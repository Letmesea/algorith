package base.huawei.face.string;

import java.util.Scanner;
import java.util.Stack;

public class KuoHaoPiPei {
    public static void main(String[] args){
        Stack<Character> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='('||str.charAt(i)=='['||str.charAt(i)=='{'){
                    stack.push(str.charAt(i));
                }
                if(str.charAt(i)==')'||str.charAt(i)==']'||str.charAt(i)=='}'){
                    if(stack.isEmpty()){
                        System.out.println(false);
                        break;
                    }
                    char c = stack.peek();
                    char ck = str.charAt(i);

                    if(c=='('&&ck==')'||c=='['&&ck==']'||c=='{'&&ck=='}'){
                        stack.pop();
                    }else{
                        System.out.println(false);
                        break;
                    }
                }
            }
            if(stack.isEmpty()){
                System.out.println(true);
            }else{
                System.out.println(false);
            }
        }
    }
}
