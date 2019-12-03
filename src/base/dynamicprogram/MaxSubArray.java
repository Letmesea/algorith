package base.dynamicprogram;

/**
 * @author Letmesea
 * @title: MaxSubArray
 * @projectName algorith
 * @description: 最大子序列和 {-2,1,-3,4,-1,2,1,-5,4}==>4-1+2+1=6
 * @date 2019/12/214:41
 */
public class MaxSubArray {

    public static void main(String[] args) {
//        int a = 2147483647;
//        int b = 1;
//        int res = a + b;
//        System.out.println(res > 0);
        int a[] = {-2,3,-3,4,-1,2,1,-5,4};
        MaxSubArray maxSubArray = new MaxSubArray();
        maxSubArray.maxSubArray(a);

    }

    //{-2,1,-3,4,-1,2,1,-5,4}
    //{-2,3,-3,4,-1,2,1,-5,4}
    //{1,-2,-3,4,-1,2,1,-5,4}
    //{4,-2,3,4,-1,2,1,-5,4}
    //{4,-5,3,4,-1,2,1,-5,4}
    //{1,2,3,4,-1,2,1,-5,4}
    //{2,1,3,4,-1,2,1,-5,4}
    //{2, 1, 3, 4, -1, -8, 2, 4, 4, 4, -5, 4}
    public int maxSubArray(int[] nums) {
        int i = 0, j = 0, k = 1;
        int tem = nums[0];
        int maxVal = nums[0];
        while (k < nums.length) {
            int ic = addOver(tem, nums[k]);
            if(ic<nums[k]){
                maxVal=nums[k];
                tem = nums[k];
                k++;
                continue;
            }
            int tem1 = ic;
            if(ic>maxVal){
                if(ic==0){
                    tem=nums[k];
                }else
                    tem=ic;
                maxVal = maxVal>tem?maxVal:tem;
            }else{
                if(tem1<0){
                    tem=0;
                }else{
                    tem=tem1;
                }
            }
            k++;
        }
        return maxVal;
    }

    //{-2,1,-3,4,-1,2,1,-5,4}
    //{-2,3,-3,4,-1,2,1,-5,4}
    //{1,-2,-3,4,-1,2,1,-5,4}
    //{4,-2,3,4,-1,2,1,-5,4}
    //{4,-5,3,4,-1,2,1,-5,4}
    //{1,2,3,4,-1,2,1,-5,4}
    //{2,1,3,4,-1,2,1,-5,4}
    public int addOver(int a, int b) {
        if (a < 0 && b < 0 && a + b > 0) {
            return Integer.MIN_VALUE;
        } else if (a > 0 && b > 0 && a + b < 0) {
            return Integer.MAX_VALUE;
        } else {
            return a + b;
        }
    }

    public int isOver(int a, int b) {
        if (a < 0 && b < 0 && a + b >= 0) {
            return -1;
        } else if (a > 0 && b > 0 && a + b <= 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
