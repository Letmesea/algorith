package base.array;

/**
 * @author Letmesea
 * @title: BetterTime2DealStock
 * @projectName leetCode
 * @description: TODO
 * @date 2019/9/2415:45
 */
public class BetterTime2DealStock {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                profit += prices[i]-prices[i-1];
            }
        }
        return profit;
    }
    public static void main(String[] args){
        BetterTime2DealStock bt2ds = new BetterTime2DealStock();
        int a[] = {7,1,5,3,4,6};
        System.out.println(bt2ds.maxProfit(a));
        //[7,5,3,1,4,6]
    }
}
