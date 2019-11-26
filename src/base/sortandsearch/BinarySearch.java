package base.sortandsearch;

/**
 * @author Letmesea
 * @title: BinarySearch
 * @projectName algorith
 * @description: TODO
 * @date 2019/11/2619:49
 */
public class BinarySearch {
    public int firstBadVersion(int n) {
        if(isBadVersion(1)){
            return 1;
        }
        int low = 1;
        int high = n;
        int middle = 0;			//定义middle
        int error = 0;
        while(low <= high){
            middle = low+(high-low)/2;//如果是(high+low)/2的话--->要考虑溢出
            if(isBadVersion(middle)){
                high=middle-1;
                error = middle;
            }else{
                low=middle+1;
            }
        }
        return error==0?n:error;


    }
    boolean isBadVersion(int version){
        return false;
    }
}
