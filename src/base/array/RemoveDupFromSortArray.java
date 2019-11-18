package base.array;

/**
 * @author Letmesea
 * @title: RemoveDupFromSortArray
 * @projectName leetCode
 * @description: TODO
 * @date 2019/9/2313:45
 */
public class RemoveDupFromSortArray {
    public int removeDuplicates(int[] nums) {
        //排序\未排序 0,1,1,3,5,5,7,8,8,8,8,9,9,10
/*        int l=1;boolean f=false;
        for(int j=1;j<nums.length;j++){
            for(int k=0;k<l;k++){
                if(nums[j]==nums[k]){
                    f=true;
                    break;
                }
            }
            if(f){
                f = false;
            }else{
                l++;
                nums[l-1]=nums[j];
            }
        }
        return l;*/
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                nums[++i]=nums[j];
            }
        }
        return i+1;
    }
    public static void main(String[] args){
        RemoveDupFromSortArray rdfsa = new RemoveDupFromSortArray();
        int[] nums = {0,1,1,3,5,5,7,8,8,8,8,9,9,10};
        int len = rdfsa.removeDuplicates(nums);
        for (int i=0;i<len;i++){
            System.out.println(nums[i]);
        }
    }
}
