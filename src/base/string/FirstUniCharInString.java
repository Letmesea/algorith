package base.string;

import java.util.Random;

/**
 * @author Letmesea
 * @title: FirstUniCharInString
 * @projectName leetCode
 * @description: 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
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
