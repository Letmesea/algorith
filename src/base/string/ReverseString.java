package base.string;

/**
 * @author Letmesea
 * @title: ReverseString
 * @projectName leetCode
 * @description: 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 *
 *
 * 示例 1：
 *
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 *
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * @date 2019/10/1710:10
 */
public class ReverseString {
    public static void reverseString(char[] s) {
        int i=0,j=s.length-1;
        while (j>i){
            if(s[j]!=s[i]){
                char t=s[i];
                s[i]=s[j];
                s[j]=t;
            }
            i++;
            j--;
        }
//        int n = s.length;
//        for (int i = 0; i < n / 2; ++i) {
//            int j = n - 1 - i;
//            s[i] ^= s[j];
//            s[j] ^= s[i];
//            s[i] ^= s[j];
//        }
    }
    public static void main(String[] args){
        char a[] = {'H','a','1','2','a','h'};
        reverseString(a);
        System.out.print(a);
    }
}
