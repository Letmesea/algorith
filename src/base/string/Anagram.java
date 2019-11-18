package base.string;

import java.util.Arrays;

/**
 * @author Letmesea
 * @title: Anagram
 * @projectName leetCode
 * @description: TODO
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
