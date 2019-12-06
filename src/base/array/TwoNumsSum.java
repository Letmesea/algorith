package base.array;

import java.util.Arrays;

/**
 * @author Letmesea
 * @title: TwoNumsSum
 * @projectName leetCode
 * @description: 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
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
                    if(b[j]==nums[k]){
                        res[0] = j;
                        break;
                    }
                }
                for(int j=b.length-1;j>=0;j--){
                    if(b[j]==nums[i]){
                        res[1] = j;
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
        int[] a = {-3, 4,3,90};
        int[] b = twoSum(a, 0);
        System.out.print(111);
    }
}
