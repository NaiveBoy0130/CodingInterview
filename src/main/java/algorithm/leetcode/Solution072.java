package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 编辑距离
 * @date: 2018/08/24
 */
public class Solution072 {
    public int minDistance(String word1, String word2) {
        if (null == word1 || null == word2) {
            return 0;
        }

        int len1 = word1.length();
        int len2 = word2.length();
        // dp[i][j]表示: word1[0:i] 和 word2[0:j]的编辑距离
        int[][] dp = new int[len1 + 1][len2 + 1];

        // 初始化第一行
        for (int j = 1; j <= len2; ++j) {
            dp[0][j] = j;
        }
        // 初始化第一列
        for (int i = 1; i <= len1; ++i) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                // 当前位置字符相同,编辑距离等于上一位置的编辑距离
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 当前位置字符不相同,有三种编辑方式
                    // 1. 从 i-1,j-1 位置变换过来,替换word1该位置字符
                    // 2. 从 i-1,j 位置变换过来,为word1添加一个字符
                    // 3. 从 i,j-1 位置变换过来,删除word1一个字符
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}
