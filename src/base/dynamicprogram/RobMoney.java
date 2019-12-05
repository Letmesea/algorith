package base.dynamicprogram;

import java.util.*;

/**
 * @author Letmesea
 * @title: RobMoney
 * @projectName algorith
 * @description:
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * @date 2019/12/414:10
 */
public class RobMoney {
    public static void main(String[] args){

    }
    public int rob(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            map.put(i,nums[i]);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        int j=list.size()-2;
        int sum=list.get(list.size()-1).getValue();
        List<Integer> list1 = new ArrayList<>();
        list1.add(list.get(list.size()-1).getKey());
        while (j>=0){
            boolean isNbr = false;
            for(int i=0;i<list1.size();i++){
                if(Math.abs(list.get(j).getKey()-list1.get(i))==1){
                    isNbr = true;
                    break;
                }
            }
            if(isNbr){
                j--;
            }else{
                if(sum+list.get(j).getValue()<0){
                    return Integer.MAX_VALUE;
                }else{
                    sum+=list.get(j).getValue();
                    list1.add(list.get(j).getKey());
                    j--;
                }
            }
        }
        return sum;
    }
}
