package algo.sort;

/**
 * Insertion Sort implementation
 */
public class Insertion extends GenericSort{

    @Override
    public <E extends Comparable<? super E>> void sort(E[] arr) {
        for (int i=1;i<arr.length;i++){
            E key = arr[i];
            int c = i -1;
            while (c >= 0 && less(key, arr[c])) {
                arr[c+1] = arr[c];
                c--;
            }
            arr[c+1] = key;

        }
    }

    private <E extends Comparable<? super E>> void shortSort(E[] arr) {
        for (int i=0; i<arr.length;i++) {
            int c = i;
            while (--c >= 0 && less(arr[c+1], arr[c])) swap(arr, c, c + 1);
        }
    }

    public static void main(String[] args) {
        new Insertion().test();
    }
}
