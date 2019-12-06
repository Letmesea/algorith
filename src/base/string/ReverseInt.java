package base.string;

/**
 * @author Letmesea
 * @title: ReverseInt
 * @projectName leetCode
 * @description: 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @date 2019/10/1713:33
 */
public class ReverseInt {
    public static int reverse(int x) {
        if(x==0)return 0;
        char[] c =  String.valueOf(x).toCharArray();
        int s = c[0]=='-'?1:0;
        int j = c.length-1;
        while (j>s){
            if(c[j]!=c[s]){
                char t=c[s];
                c[s]=c[j];
                c[j]=t;
            }
            s++;
            j--;
        }
        j=0;
        StringBuilder sb = new StringBuilder();
        if(c[0]=='-'){
            sb.append('-');
        }
        while (c[j]=='-'||c[j]=='0'){j++;}
        for (int i=j;i<c.length;i++){
            sb.append(c[i]);
        }
        try {
            int res = Integer.valueOf(sb.toString());
            return res;
        }catch (Exception e){
            return 0;
        }
    }
    public static void main(String[] args){
        reverse(1534236469);
    }
}
