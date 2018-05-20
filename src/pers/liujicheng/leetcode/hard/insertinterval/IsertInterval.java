package pers.liujicheng.leetcode.hard.insertinterval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by JC on 2018/5/20.
 * <p>
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 * <p>
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class IsertInterval {

    public IsertInterval() {
        Interval item = new Interval();
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(6, 9));

        insert(list, new Interval(2, 5));
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.isEmpty() && null == newInterval) {
            return Collections.EMPTY_LIST;
        }
        if (null == newInterval) {
            return intervals;
        }

        List<Interval> list = new ArrayList<>();
        if (intervals.isEmpty()) {
            list.add(newInterval);
            return list;
        }
        boolean hasInsert = false;

        for (int i = 0; i < intervals.size(); i++) {
            Interval thisval = intervals.get(i);

            if (!hasInsert && thisval.start >= newInterval.start) {
                list.add(newInterval);
                hasInsert = true;
            }

            boolean has = false;
            if (thisval.start <= newInterval.start && thisval.end >= newInterval.start) {
                newInterval.start = thisval.start;
                has = true;
            } else if (thisval.start >= newInterval.start && thisval.start <= newInterval.end) {
                has = true;
            }

            if (thisval.end >= newInterval.end && thisval.start <= newInterval.end) {
                newInterval.end = thisval.end;
                has = true;
            } else if (thisval.end <= newInterval.end && thisval.end >= newInterval.start) {
                has = true;
            }

            if (!has) {
                list.add(thisval);
            }
        }

        if (!hasInsert) {
            list.add(newInterval);
        }


        return list;
    }


    public class Interval {
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

    public static void main(String[] args) {
        new IsertInterval();
    }

}
