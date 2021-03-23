package base.array;

/**
 * 跳跃游戏2:
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 *
 *
 * 跳跃游戏:
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 */
public class JumpGame {
    static int jump2(int [] nums) {
        int n = nums.length;
        int[] f=new int[n];
        int last = 0;
        f[0] = 0;
        for(int i = 1; i < n; i++){
            while(i > last + nums[last])
            {
                last++;
            }
            f[i] = f[last] + 1;
        }
        return f[n - 1];
    }

    /**
     * 跳跃游戏，判断是否可以到达最后一个位置
     * @param nums
     * @return
     */
    public static boolean jump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(jump2(new int[]{3,2,1,0,4}));
    }
}
