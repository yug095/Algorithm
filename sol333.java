/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public class Result {
        int nodeNum;
        int min;
        int max;
        public Result(int nodeNum, int min, int max) {
            this.nodeNum = nodeNum;
            this.min = min;
            this.max = max;
        }
    }
    public int largestBSTSubtree(TreeNode root) {
        Result res = traverse (root);
        return Math.abs(res.nodeNum);
    }
    
    public Result traverse(TreeNode node) {
        if(node==null) {
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        } 
        Result leftRes = traverse(node.left);
        Result rightRes = traverse(node.right);
        if(leftRes.nodeNum<0||rightRes.nodeNum<0||node.val<leftRes.max||node.val>rightRes.min) {
            return new Result(Math.max(Math.abs(leftRes.nodeNum), Math.abs(rightRes.nodeNum))*-1, 0, 0);
        } else {
            return new Result (leftRes.nodeNum+rightRes.nodeNum+1, Math.min(node.val, leftRes.min), 
                       Math.max(node.val, rightRes.max));
        }
    }
    
}


// 1. Two Sum 
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] res = new int [2];
        int len = nums.length;
        for (int i = 0; i< len -1 ;i++) {
            for (int j = i + 1; j<len; j ++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i; 
                    res[1] = j;
                }
            }
        }
        return res;
    }
}