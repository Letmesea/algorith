package base.array;

/**
 * @author Letmesea
 * @title: OnlyOnceInArray
 * @projectName leetCode
 * @description: TODO
 * @date 2019/10/810:32
 */
public class OnlyOnceInArray {
    public int singleNumber(int[] nums) {
/*        Arrays.sort(nums);
        for(int i=0;i<nums.length;){
            if(i==nums.length-1){
                return nums[nums.length-1];
            }
            if(nums[i]!=nums[i+1]) {
                return nums[i];
            }
            else{
                i=i+2;
            }
        }
        return 0;*/
/*位运算，最快*/
        int ans = 0;
        for(int num: nums) {
            ans ^= num;
        }
        return ans;
    }
    public static void main(String[] args){
        int a[] = {1,9};
        OnlyOnceInArray aed = new OnlyOnceInArray();
        System.out.println(aed.singleNumber(a));
    }
}
