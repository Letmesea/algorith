package base.sortandsearch;

import java.util.Arrays;

/**
 * @author Letmesea
 * @title: merge2SortArray
 * @projectName algorith
 * @description: TODO
 * @date 2019/11/2615:56
 */
public class merge2SortArray {
    public static void main(String[] args){
        int nums1[] = {1,2,3,0,0,0};
        int nums2[] = {5,6};
        merge1(nums1,3,nums2,2);
        System.out.println(111);
    }

    /**
     * 合并两个有序数组
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * 输出: [1,2,2,3,5,6]
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int arr[] = new int[m+n];
        int i=0,j=0,k=0;
        while (i<m&&j<n){
            if(nums1[i]<=nums2[j]){
                arr[k++]=nums1[i++];
            }else{
                arr[k++] = nums2[j++];
            }
        }
        for (int i1=i;i1<m;i1++){
            arr[k++]=nums1[i1];
        }
        for (int j1=j;j1<n;j1++){
            arr[k++]=nums2[j1];
        }
        for(i=0;i<arr.length;i++){
            nums1[i]=arr[i];
        }
    }

    /**
     * 合并2个有序数组
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n){
//        if(n==0){
//            return;
//        }
//        int i=0,j=0;
//        while (i<m){
//            if(nums1[i]>=nums2[0]){
//                int tmp = nums1[i];
//                nums1[i]=nums2[0];
//                nums2[0]=tmp;
//                Arrays.sort(nums2);
//            }
//            i++;
//        }
//        for (;j<n;j++){
//            nums1[i++] = nums2[j];
//        }

        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
 }
