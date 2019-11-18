package base.string;

/**
 * @author Letmesea
 * @title: ReverseString
 * @projectName leetCode
 * @description: TODO
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
