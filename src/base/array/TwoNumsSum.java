package base.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Letmesea
 * @title: TwoNumsSum
 * @projectName leetCode
 * @description: TODO
 * @date 2019/10/1418:51
 */
public class TwoNumsSum {
    public static int[] twoSum(int[] nums, int target) {
        int [] b = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            b[i]=nums[i];
        }
        Arrays.sort(nums);
        int k = 0;
        int res[] = new int[2];
        int k1 = nums.length - 1;
        for (int i = k1; i >= 0 && k <= k1; ) {
            if (nums[i] + nums[k] == target) {
                for(int j=0;j<b.length;j++){
                    if(nums[k]==b[j]){
                        res[0]=j;
                        break;
                    }
                }
                for(int j=b.length-1;j>=0;j--){
                    if(nums[i]==b[j]){
                        res[1]=j;
                        break;
                    }
                }
                return res;
            } else if (nums[i] + nums[k] > target) {
                i--;
            } else {
                k++;
            }
        }
        return res;
    }

    public static int myBinarySearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (value > arr[mid]) {
                low = mid + 1;
            }
            if (value == arr[mid]) {
                return mid;
            }
            if (value < arr[mid]) {
                high = mid - 1;
            }
        }
        return -1;//没有找到返回-1
    }

    public static void main(String[] args) {
//        int [] a= new int[10];
//        Random random = new Random();
//        for(int i=0;i<10;i++){
//            a[i] = random.nextInt(15);
//        }
        int[] a = {3,2,2,6,5,7,5};
        int[] b = twoSum(a, 10);
        System.out.print(111);
    }
}
