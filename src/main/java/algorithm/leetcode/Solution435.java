package algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: mayuan
 * @desc: 无重叠区间
 * @date: 2018/08/18
 */
public class Solution435 {
    public static void main(String[] args) {

    }

    /**
     * 计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。
     * 在每次选择中，区间的结尾最为重要，选择的区间结尾越小，留给后面的区间的空间越大，那么后面能够选择的区间个数也就越大。
     * 按区间的结尾进行排序，每次选择结尾最小，并且和前一个区间不重叠的区间。
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (null == intervals || 0 >= intervals.length) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a.end - b.end);

        int cnt = 1;
        int end = intervals[0].end;
        for (int i = 1; i < intervals.length; ++i) {
            if (end <= intervals[i].start) {
                ++cnt;
                end = intervals[i].end;
            }
        }
        return intervals.length - cnt;
    }

    private class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}


