package base.array;

import java.util.Arrays;

/**
 * @author Letmesea
 * @title: BetterTime2DealStock
 * @projectName leetCode
 * @description: 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,1,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * @date 2019/9/2415:45
 */
public class BetterTime2DealStock {
    /**
     * 买卖股票最佳时机2
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                profit += prices[i]-prices[i-1];
            }
        }
        return profit;
    }

    /**
     *
     * 假设不能多次买卖在同一天，即当天只能操作一次
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int profit = 0,j=0;
        for (int i=1;i<prices.length;){
            if (prices[i]<prices[i-1]){
                profit+=prices[i-1]-prices[j];
                j=i;i++;
            }else{
                if (i==prices.length-1){
                    profit+=prices[i]-prices[j];
                    break;
                }else{
                    i++;
                }
            }
        }
        return profit;
    }
    /**
     *
     * 买卖股票的最佳时机IV
     * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *  2
     * [3,3,5,0,0,3,1,4]
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param prices
     * @return
     */
    public int maxProfit1(int k,int[] prices) {
        if(k==0){
            return 0;
        }
        int profit = 0,j=0,kn=0;
        for (int i=1;i<prices.length;){
            if (prices[i]<prices[i-1]){
                profit+=prices[i-1]-prices[j];
                if (j!=i-1)
                    kn++;
                j=i;i++;
            }else{
                if (i==prices.length-1){
                    profit+=prices[i]-prices[j];
                    if (i!=j)
                        kn++;
                    break;
                }else{
                    i++;
                }
            }
        }
        if (kn==0)return 0;
        if (k>=kn)return profit;

        int[] bs=new int[kn];
        int[] bs1=new int[kn];
        j=0;int kn1=0,kn2=0;
        for (int i=1;i<prices.length;){
            if (prices[i]<prices[i-1]){
                if (j!=i-1)
                {bs[kn1++]=j;bs1[kn2++]=i-1;}
                j=i;i++;
            }else{
                if (i==prices.length-1){
                    if (i!=j)
                    {bs1[kn2++]=i;bs[kn1++]=j;}
                    break;
                }else{
                    i++;
                }
            }
        }
        int ch[][] = new int[kn][kn];
        for (int i=0;i<=kn;i++){

        }

        return profit;
    }

    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     *
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     *
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     *[7,1,5,0,6]
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
    public static void main(String[] args){
        int we =Double.valueOf("0").intValue();
        BetterTime2DealStock bt2ds = new BetterTime2DealStock();
//        int a[] = {1,2,4,2,5,7,2,4,9,0};
        int a[] = {1,2,4,2,5,7,0,4,9,0};
        System.out.println(bt2ds.maxProfit1(1,a));
        //[7,5,3,1,4,6]

    }
}
