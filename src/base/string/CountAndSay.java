package base.string;

/**
 * @author Letmesea
 * @title: CountAndSay
 * @projectName leetCode
 * @description: 报数
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 * @date 2019/10/3015:44
 */
public class CountAndSay {
    public static String countAndSay(int n) {
        int i = 0, j = 1, k = 0;
        StringBuilder sb = n>1?new StringBuilder("11"):new StringBuilder("1");
        StringBuilder sb1;
        do {
            if(n>2){
                sb1 = new StringBuilder();
                for (; j < sb.length(); ) {
                    char ck = sb.charAt(k);
                    char cj = sb.charAt(j);
                    if (ck == cj) {
                        j++;
                        if(j==sb.length()){
                            sb1.append(j-k);
                            sb1.append(ck);
                        }
                    } else {
                        sb1.append(j - k);
                        sb1.append(ck);
                        k = j;j++;
                        if(j==sb.length()){
                            sb1.append(j-k);
                            sb1.append(sb.charAt(k));
                        }
                    }
                }
                sb = sb1;
            }
            i++;
            j = 1;
            k = 0;
        } while (i < n-2);
        return sb.toString();
    }

    public static void main(String[] args) {
        String res = countAndSay(2);
        System.out.println(res);
    }
}
