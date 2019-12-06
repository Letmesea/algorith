package base.string;

import java.util.Arrays;

/**
 * @author Letmesea
 * @title: Anagram
 * @projectName leetCode
 * @description: 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * @date 2019/10/2410:02
 */
public class Anagram {
    public static boolean isAnagram(String s, String t) {
        char ss[] = s.toCharArray();
        char ts[] = t.toCharArray();
        if(ss.length!=ts.length){return false;}
        Arrays.sort(ss);
        Arrays.sort(ts);
        for (int i=0;i<ss.length;i++){
            if(ss[i]!=ts[i]){
                return false;
            }
        }
        return true;
    }
    public static boolean isAnagram1(String s, String t) {
return false;
    }
    public static boolean isAnagram2(String s, String t) {
        if(s.length()!=t.length()){return false;}
        int [] a1= new int[26];
        int [] a2 = new int[26];
        for (int i=0;i<s.length();i++){
            a1[s.charAt(i)-'a']++;
        }
        for (int i=0;i<t.length();i++){
            a2[t.charAt(i)-'a']++;
        }
        for (int i=0;i<26;i++){
            if(a1[i]!=a2[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        //abc bac
        isAnagram2("anagram","nagaram");
    }
}
