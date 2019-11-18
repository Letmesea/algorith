package test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Letmesea
 * @title: singleScan
 * @projectName leetCode
 * @description: TODO
 * @date 2019/10/109:34
 */
public class SingleScan {
    public void forwardScanSort(int[] items) {
        forwardScanSort(items, 0, items.length - 1);
    }

    public void forwardScanSort(int[] items, int start, int end) {
        if (start < end) {
            int pivot = items[start];
            int i = start, j = start + 1;
            while (j <= end) {
                if (items[j] < pivot) {
                    i++;
                    if(i!=j)
                    swap(items, i, j);
                }
                j++;
            }
            swap(items, start, i);
            forwardScanSort(items, start, i - 1);
            forwardScanSort(items, i + 1, end);
        }
    }
    public void swap(int[] items,int i,int j){
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
    public static void main(String[] args){
        SingleScan singleScan = new SingleScan();
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        int a [] = {4,3,2,1,5};
        singleScan.forwardScanSort(a);
        System.out.print(1);
    }
}
