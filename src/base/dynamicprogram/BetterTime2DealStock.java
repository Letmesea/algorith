package base.dynamicprogram;

import com.sun.javafx.collections.MappingChange;
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
    public static void main(String[] args) {
        int req[] = {6,1,3,2,4,7};//{7,1,5,3,4,6}  {7,5,4,3,1,3} {7,6,5,5,6} {2,4,1}
        // {2,4,1}  {1,2,4}
        // {0,1,2}  {2,0,1}
        int res = maxProfit(req);
    }

    /**
     * 最大利润（会超时）
     *
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < prices.length; i++) {
            map.put(i, prices[i]);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        Map<Integer, Integer> map1 = new TreeMap<>();
        int i = 0, j = list.size() - 1;
        while (j > 0) {
            if (list.get(i).getKey() > list.get(j).getKey()) {
                i++;
            } else if (list.get(i).getKey() == list.get(j).getKey()) {
                j--;
                i = 0;
            } else {
                map1.put(list.get(j).getValue() - list.get(i).getValue(), 1);
                i++;
            }
        }
        return map1.isEmpty() ? 0 : ((TreeMap<Integer, Integer>) map1).lastEntry().getKey();
    }

    /**
     * 最大利润(一次遍历)
     *
     * @param prices {3,3,5,0,0,3,1,4}
     * @return
     */
    public static int maxProfit(int[] prices) {
        int i = 0, j = 0, k = 1;
        int maxProfit=0;
        for (; k < prices.length; k++) {
            if (prices[k] > prices[k - 1]) {
                if (prices[k] > prices[j] && prices[k] > prices[i]) {
                    maxProfit = (prices[k]-prices[i])>maxProfit?(prices[k]-prices[i]):maxProfit;
                    j=k;
                }
            }else{
                if(prices[k]<prices[i]){
                    i=k;
                    j=k;
                }
            }
        }
        return maxProfit;
    }
}
