package algo.wadiz0821;

import java.util.List;

public class Third {

    public void print(int[] arr, int l, int r) {
        for (int i=l;i<=r;i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println("left="+l+" right="+r);
    }

    public void sub(int[] arr, int left, int right) {
        int min = arr[left];
        for (int i=left;i<=right;i++) min = Math.min(min, arr[i]);

        for (int i=left;i<=right;i++) {
            arr[i]-=min;
        }
    }

    public int track(int[] arr, int left, int right) {
        print(arr, left, right);
        if (left == right) {
            return arr[left] != 0 ? 1 : 0;
        }
        int count = 0;
        while (arr[left] == 0 && left < right) left++;
        while (arr[right] == 0 && left > right) right--;
        if (left >= right) return 0;

        int i = left, j = left;
        while (i <= right) {
            if (arr[i] == 0) {
                count += track(arr, j, i-1);
                j = i + 1;
            }
            i++;
        }
        if (arr[right] != 0) {
            if (j == left) {
                sub(arr, left, right);
                return track(arr, left, right) + 1;
            }
            count += track(arr, j, right);
        }
        return count;
    }

    public int solution(int[] arr) {
        return track(arr, 0, arr.length-1);
    }

    public static void main(String[] args) {
        int[] A = {1,3,5,7,2,1,8,9,2,1};
        int[] B = {1,2,4,8,4,2,1};
        int[] C = {1,3,5,7,6,8,9,5,1};
        int[] D = {10,0,10,0,10,0};
        int[] E = {5,4,5,4,5,5};
        int[] F = {1,1,1,1};

        System.out.println(new Third().solution(F)+" answer ----");
    }

}
