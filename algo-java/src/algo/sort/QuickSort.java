package algo.sort;

/**
 * Quick sort implementation
 * - lomuto partition
 */
public class QuickSort extends GenericSort {


    @Override
    public <E extends Comparable<? super E>> void sort(E[] arr) {
//        sort(arr, 0, arr.length - 1);
        threeWaySort(arr,0,arr.length-1);
    }


    private <E extends Comparable<? super E>> void sort(E[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int pivot = partitionF(arr, lo, hi);
        sort(arr, lo, pivot - 1);
        sort(arr, pivot + 1, hi);
    }

    // 배열의 lo ~ hi 범위 만큼 마지막 값을 피벗으로 나눈다
    private <E extends Comparable<? super E>> int partition(E[] arr, int lo, int hi) {
        E pivot = arr[hi];
        for (int i = lo; i < hi; i++) {
            if (pivot.compareTo(arr[i]) >= 0) {
                swap(arr, lo++, i);
            }
        }
        swap(arr, lo, hi);
        return lo;
    }

    // 첫번째 값을 피벗으로 잡는 partition
    private <E extends Comparable<? super E>> int partitionF(E[] arr, int lo, int hi) {
        E pivot = arr[lo]; // 첫번째 값을 pivot 으로
        int left = lo, right = hi + 1;
        while (true) {
            while (less(arr[++left], pivot) && left < hi);
            while (less(pivot, arr[--right]) && right >= lo);
            if (left >= right) break;
            swap(arr, left, right);
        }
        swap(arr, lo, right);
        return right;
    }

    // three pivot
    private <E extends Comparable<? super E>> void threeWaySort(E[] arr, int lo, int hi){
        if (hi <= lo) return;
        int lt = lo, i = lo+1, gt = hi;
        E v = arr[lo];
        while (i <= gt) {
            int cmp = arr[i].compareTo(v);
            if (cmp < 0) swap(arr, i++, lt++);
            else if (cmp > 0) swap(arr, i, gt--);
            else i++;
        }
        threeWaySort(arr, lo, lt - 1);
        threeWaySort(arr, gt + 1, hi);
    }

    public static void main(String[] args) {
        new QuickSort().test();
    }

}
