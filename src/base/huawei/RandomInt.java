package base.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class RandomInt {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int[] nums = new int[1001];
            int n = sc.nextInt();
            for(int i=0;i<n;i++){
                int m = sc.nextInt();
                nums[m] = 1;
            }
            for(int i=0;i<nums.length;i++){
                if(nums[i]==1){
                    System.out.println(i);
                }
            }
        }
    }
}
