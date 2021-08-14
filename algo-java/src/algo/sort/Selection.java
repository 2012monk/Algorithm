package algo.sort;

public class Selection extends GenericSort{


    @Override
    public <E extends Comparable<? super E>> void sort(E[] arr) {
        for (int i=0;i<arr.length; i++) {
            int smallest = i;
            for (int j=i;j<arr.length;j++) {
                if (less(arr[j], arr[smallest])) smallest = j;
            }
            swap(arr, i, smallest);
        }
    }
}
