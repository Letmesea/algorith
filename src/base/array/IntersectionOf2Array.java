package base.array;

import java.util.*;

/**
 * @author Letmesea
 * @title: IntersectionOf2Array
 * @projectName leetCode
 * @description: 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * @date 2019/10/913:54
 */
public class IntersectionOf2Array {
    public static void main(String[] args){
        int a[] = {1,1,2,2,3,4,5},b[]={1,1,2,3,3,3,3,3,3};
        IntersectionOf2Array aed = new IntersectionOf2Array();
        int c[] = aed.intersect2(a,b);
        for (int i:c){
            System.out.print(i+" ");
        }
    }

    /**
     * 双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<Integer>();
        int p1=0,p2=0;
        if(nums1.length>0&&nums2.length>0){
            while (p1<nums1.length&&p2<nums2.length) {
                if (nums1[p1] > nums2[p2]) {
                    p2++;
                } else if (nums1[p1] < nums2[p2]) {
                    p1++;
                } else {
                    list.add(nums1[p1]);
                    p1++;
                    p2++;
                }
            }
        }
        int[] r = new int[list.size()];
        for (int i=0;i<list.size();i++){
            r[i] = list.get(i);
        }
        return r;
    }

    /**
     * map
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i],map.get(nums1[i])+1);
            }else{
                map.put(nums1[i],1);
            }
        }
        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i])){
                map.put(nums2[i],map.get(nums2[i])-1);
                if(map.get(nums2[i])==0){
                    map.remove(nums2[i]);
                }
                list.add(nums2[i]);
            }
        }
        int[] r = new int[list.size()];
        for (int i=0;i<list.size();i++){
            r[i] = list.get(i);
        }
        return r;
    }
}
