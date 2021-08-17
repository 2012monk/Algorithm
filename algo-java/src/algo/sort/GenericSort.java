package algo.sort;

import java.util.Random;

/**
 * 정렬 알고리즘 구현에 필요한 메서드들을 모아 놓은 상위 클래스
 */
public abstract class GenericSort {

    /**
     * @param a 기준 대상
     * @param b 비교 대상
     * @return if a < b then true else false
     */
    static <E extends Comparable<? super E>> boolean less(E a, E b) {
        return a.compareTo(b) < 0;

    }

    /**
     * 주어진 두개의 인덱스값을 서로 교환한다
     *
     * @param arr 대상 배열
     * @param i   인덱스 1
     * @param j   인덱스 2
     */
    static <E extends Comparable<? super E>> void swap(E[] arr, int i, int j) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static protected <E extends Comparable<? super E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (less(arr[i], arr[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public <E extends Comparable<? super E>> void printAndEval(E[] arr) {
        System.out.printf("sorted complete Array length of %d\n ", arr.length);
        for (E e : arr) {
            System.out.printf("%s, ", e.toString());
        }
    }

    public abstract <E extends Comparable<? super E>> void sort(E[] arr); /* implement sort */

    public void test() {
        int size = 1 << 16;
        Integer[] arr = new Integer[size];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(size);
        }
        long st = System.nanoTime();
        sort(arr);
        double e = (double) (System.nanoTime() - st) / 1_000_000_000;
        System.out.println("time takes : " + e + "s");
        if (isSorted(arr)) {
//            printAndEval(arr);
            System.out.println("Sort complete");
        } else {
            System.out.println("Failed array not sorted");
        }

    }
}
