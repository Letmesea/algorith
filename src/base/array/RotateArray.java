package base.array;

/**
 * @author Letmesea
 * @title: RotateArray
 * @projectName leetCode
 * @description: TODO
 * @date 2019/9/2916:32
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
            if(k>0){
               k = k%nums.length;
                int a[] = new int[nums.length];
                int j=0;
                for(int i=nums.length-k;i<nums.length;i++){
                    a[j++] = nums[i];
                }
                for (int i=0;i<nums.length-k;i++){
                    a[j++] = nums[i];
                }
                for(int i=0;i<nums.length;i++){
                    nums[i]= a[i];
                }
            }

    }
    public static void main(String[] args){
        RotateArray ra = new RotateArray();
        int a[] = {1,2,3,4,5,4,12,13,6,7,8,9,100};
        ra.rotate(a,1);
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
