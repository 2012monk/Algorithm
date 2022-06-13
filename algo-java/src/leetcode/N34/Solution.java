package leetcode.N34;

public class Solution {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] {-1,-1};
        int lo = lowerBound(nums, target);
        int hi = upperBound(nums, target);
        if (lo != hi && nums[hi] != target) hi--;
        if (nums[lo] != target)return new int[]{-1,-1};
        return new int[]{lo, hi};
    }

    public int upperBound(int[] a, int t) {
        int lo = 0, hi = a.length - 1, mid;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (a[mid] <= t) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;

    }

    public int lowerBound(int[] a, int t) {
        int lo = 0, hi = a.length - 1, mid;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (a[mid] < t) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

}