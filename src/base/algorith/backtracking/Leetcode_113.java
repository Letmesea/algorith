package base.algorith.backtracking;

import list.Link;

import java.util.*;

/**
 * 路径总和2:
 *
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *                  5
 *              4      8
 *          11      13    4
 *       7     2        5    1
 *
 * 示例 1：
 *
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 *
 */
public class Leetcode_113 {
    /**
     * 广度优先
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Map<TreeNode,TreeNode> map = new HashMap<>();
        if (root==null){
            return lists;
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        Queue<Integer> integers = new LinkedList<>();
        treeNodes.add(root);
        integers.add(root.val);
        while (!treeNodes.isEmpty()){
            TreeNode node = treeNodes.poll();
            int val=integers.poll();
            if (node.left==null&&node.right==null){
                if (val==targetSum){
                    List<Integer> list = new ArrayList<>();
                    while (node!=null){
                        list.add(node.val);
                        node=map.get(node);
                    }
                    Collections.reverse(list);
                    lists.add(list);
                }
                continue;
            }
            if (node.left!=null){
                treeNodes.add(node.left);
                integers.add(node.left.val+val);
                map.put(node.left,node);
            }
            if (node.right!=null){
                treeNodes.add(node.right);
                integers.add(node.right.val+val);
                map.put(node.right,node);
            }
        }
        return lists;
    }

    /**
     * 递归实现
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum1(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        Deque<Integer> path = new LinkedList<Integer>();
        dfs(root, sum,path,ret);
        return ret;
    }

    public void dfs(TreeNode root, int sum,Deque<Integer> path,List<List<Integer>> ret) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, sum,path,ret);
        dfs(root.right, sum,path,ret);
        path.pollLast();
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(5,
                new TreeNode(4,new TreeNode(11,new TreeNode(7,null,null),new TreeNode(2,null,null)),null)
                ,new TreeNode(8,new TreeNode(13,null,null),new TreeNode(4,new TreeNode(5,null,null),new TreeNode(1,null,null))));
        System.out.println(new Leetcode_113().pathSum1(root,22));
    }

}
