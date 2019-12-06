package base.array;

/**
 * @author Letmesea
 * @title: AddOne
 * @projectName leetCode
 * @description:
 * 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * @date 2019/10/1214:16
 */
public class AddOne {
    public static int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]==9){
                if(i!=0){
                    digits[i] = 0;
                }else{
                    int[] a = new int[digits.length+1];
                    a[0] = 1;
                    return a;
                }
            }else{
                digits[i]++;
                return digits;
            }
        }
        return digits;
    }

    public static void main(String[] args){
    }
}
