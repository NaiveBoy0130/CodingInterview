package algorithm.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 子集 II
 * @date: 2018/08/11
 */
public class Solution090 {

    public static void main(String[] args) {
        List<List<Integer>> ans = new Solution090().subsetsWithDup(new int[]{1, 2, 2});

        ans.forEach(list -> {
            for (int num : list) {
                System.out.print(num);
            }
            System.out.println();
        });

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> answer = new LinkedList<>();
        List<Integer> oneAnswer = new LinkedList<>();

        if (null == nums || 0 >= nums.length) {
            return answer;
        }

        // 必须先对数组进行排序
        Arrays.sort(nums);
        dfs(answer, oneAnswer, nums, 0);
        return answer;
    }

    public void dfs(List<List<Integer>> answer, List<Integer> oneAnswer, int[] nums, int start) {
        answer.add(new LinkedList<>(oneAnswer));

        for (int i = start; i < nums.length; i++) {
            // 去除重复的解
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            oneAnswer.add(nums[i]);
            dfs(answer, oneAnswer, nums, i + 1);
            oneAnswer.remove(oneAnswer.size() - 1);
        }
    }
}
