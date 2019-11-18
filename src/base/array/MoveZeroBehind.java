package base.array;

import java.util.Random;

/**
 * @author Letmesea
 * @title: MoveZeroBehind
 * @projectName leetCode
 * @description: TODO
 * @date 2019/10/1411:22
 */
public class MoveZeroBehind {
    public static void moveZeroes(int[] nums) {
        StringBuilder sb = new StringBuilder();
        String a = ",";
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                sb.append(nums[i]);
                sb.append(a);
            }
        }
        String str = sb.length()>0? sb.substring(0,sb.length()-1):"";
        if(!str.equals("")){
            String[] strs = str.split(",");
            for (int i=0;i<nums.length;i++){
                if(i>strs.length-1){
                    nums[i] = 0;
                }else{
                    nums[i] = Integer.valueOf(strs[i]);
                }
            }
        }
    }
    public static void moveZeroes1(int[] nums) {
        int j=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                j=i;break;
            }
        }
        if(j!=-1){
            for(int k=j+1;k<nums.length;k++){
                if(nums[k]!=0){
                    int tmp = nums[k];
                    nums[k]=0;
                    nums[j]=tmp;
                    j++;
                }
            }
        }
    }
    public static void main(String[] args){
        int [] a= new int[20];
        Random random = new Random();
        for(int i=0;i<20;i++){
            a[i] = random.nextInt(4);
//            a[i] = 0;
        }
        moveZeroes1(a);
        System.out.print(111);
    }
}
