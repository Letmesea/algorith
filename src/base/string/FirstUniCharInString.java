package base.string;

import java.util.Random;

/**
 * @author Letmesea
 * @title: FirstUniCharInString
 * @projectName leetCode
 * @description: TODO
 * @date 2019/10/1810:27
 */
public class FirstUniCharInString {
    public static int firstUniqChar1(String s) {
        int res = -1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int index = s.indexOf(ch);
            if (index != -1 && index == s.lastIndexOf(ch)) {
                res = (res == -1 || res > index) ? index : res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Random random=new Random();
        long s = System.currentTimeMillis();
        int a = firstUniqChar1("leetcode");
        long end = System.currentTimeMillis();
        long c = end-s;
        System.out.print(111);
    }
}
