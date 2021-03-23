package base.algorith.backtracking;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 路径总和：
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */

public class Leetcode_112 {

    /**
     * dfs 递归
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
         if(root==null){
             return false;
         }
         if (root.left==null&&root.right==null){
             return root.val==targetSum;
         }
         return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
    }

    /**
     * 广度优先,队列先进先出
     */
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root==null){
            return false;
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        Queue<Integer> integers = new LinkedList<>();
        treeNodes.add(root);
        integers.add(root.val);
        while (!treeNodes.isEmpty()){
            TreeNode node = treeNodes.poll();
            int val=integers.poll();
            if (node.left==null&&node.right==null){
                if (val==targetSum)
                    return true;
                continue;
            }
            if (node.left!=null){
                treeNodes.add(node.left);
                integers.add(node.left.val+val);
            }
            if (node.right!=null){
                treeNodes.add(node.right);
                integers.add(node.right.val+val);
            }
        }
        return false;
    }
    public static void main(String[] args){
         TreeNode root = new TreeNode(5,
                 new TreeNode(4,new TreeNode(11,new TreeNode(7,null,null),new TreeNode(2,null,null)),null)
                 ,new TreeNode(8,new TreeNode(13,null,null),new TreeNode(4,null,new TreeNode(1,null,null))));
         System.out.println(new Leetcode_112().hasPathSum1(root,22));
    }
}
