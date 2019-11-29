package base.dynamicprogram;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @author Letmesea
 * @title: BetterTime2DealStock
 * @projectName algorith
 * @description: 买卖股票的最佳时机（最多一次交易）
 * @date 2019/11/2911:16
 */
public class BetterTime2DealStock {
    public static void main(String[] args){
        int req[] = {7,5,4,3,1,3};//{7,1,5,3,4,6}  {7,5,4,3,1,3} {7,6,5,5,6} {2,4,1}
        // {2,4,1}  {1,2,4}
        // {0,1,2}  {2,0,1}
        int res =  maxProfit(req);
    }
    public static int maxProfit(int[] prices) {
        Map<Integer,Integer> map = new TreeMap<>();
        Map<Integer,Integer> map1 = new TreeMap<>();
        for (int i=0;i<prices.length;i++){
            if(!map.containsKey(prices[i])) {
                map.put(prices[i],i);
            }
            map1.put(prices[i],i);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        List<Map.Entry<Integer,Integer>> list1 = new ArrayList<>(map1.entrySet());
        int j=list.size()-1;
        while (0<j){
            if(list.get(j).getValue()>list.get(0).getValue()||list1.get(j).getValue()>list1.get(0).getValue()){
                return list.get(j).getKey()-list.get(0).getKey();
            }
            j--;
        }
        return 0;
    }
}
