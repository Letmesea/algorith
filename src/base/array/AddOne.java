package base.array;

/**
 * @author Letmesea
 * @title: AddOne
 * @projectName leetCode
 * @description: TODO
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
