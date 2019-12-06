package base.string;

/**
 * @author Letmesea
 * @title: IsPalindrome
 * @projectName algorith
 * @description: 验证回文字符串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 * @date 2019/12/615:31
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while (i<j){
            char ci = Character.toLowerCase(s.charAt(i));
            char cj = Character.toLowerCase(s.charAt(j));
            if((ci>='0'&&ci<='9')||(ci>='a'&&ci<='z')){
                if((cj>='0'&&cj<='9')||(cj>='a'&&cj<='z')){
                    if(ci!=cj){
                        return false;
                    }else{
                        i++;j--;
                    }
                }else{
                    j--;
                }
            }else{
                i++;
            }
        }
        return true;
    }
}
