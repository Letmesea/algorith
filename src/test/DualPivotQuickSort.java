package test;

/**
 * @author Letmesea
 * @title: DualPivotQuickSort
 * @projectName leetCode
 * @description: TODO
 * @date 2019/10/1210:42
 */
public class DualPivotQuickSort {
    public void dualPivotQuickSort(int[] items) {
        dualPivotQuickSort(items, 0, items.length - 1);
    }
    public void swap(int[] items,int i,int j){
        if(i!=j){
            int temp = items[i];
            items[i] = items[j];
            items[j] = temp;
        }
    }
    public void dualPivotQuickSort(int[] items, int start, int end) {
        if (start < end) {
            if (items[start] > items[end]) {
                swap(items, start, end);
            }
            int pivot1 = items[start], pivot2 = items[end];
            int i = start, j = end, k = start + 1;
            OUT_LOOP: while (k < j) {
                if (items[k] < pivot1) {
                    swap(items, ++i, k++);
                } else if (items[k] <= pivot2) {
                    k++;
                } else {
                    while (items[--j] > pivot2) {
                        if (j <= k) {
                            // 扫描终止
                            break OUT_LOOP;
                        }
                    }

                    if (items[j] < pivot1) {
                        swap(items, j, k);
                        swap(items, ++i, k);
                    } else {
                        swap(items, j, k);
                    }
                    k++;
                }
            }
            swap(items, start, i);
            swap(items, end, j);

            dualPivotQuickSort(items, start, i - 1);
            dualPivotQuickSort(items, i + 1, j - 1);
            dualPivotQuickSort(items, j + 1, end);
        }
    }
    public static void main(String[] args){
        DualPivotQuickSort singleScan = new DualPivotQuickSort();
        int a [] = {4,3,2,1,5,7,6};
        singleScan.dualPivotQuickSort(a);
        System.out.print(1);
    }
}
