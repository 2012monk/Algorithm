package algo.sort;

/**
 * Shell sort implementation
 * 수열 1,5,19,41,109,209... 3x + 1
 */
public class Shell extends GenericSort{

    @Override
    public <E extends Comparable<? super E>> void sort(E[] arr) {
        int n = arr.length;
        int h = 1;
        while (h < n / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i=h; i<n; i++) {
                for (int j = i; j >= h && less(arr[j], arr[j - h]); j -= h) {
                    swap(arr, j, j - h);
                }
            }
            h = h/3;
        }
    }

    public static void main(String[] args) {
        new Shell().test();
    }
}
