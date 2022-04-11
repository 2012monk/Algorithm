package BOJ.N10972다음순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static int n;
    static int[] target;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        target = new int[n];
        stz = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            target[i] = Integer.parseInt(stz.nextToken());
        }
        if (solve()) {
            for (int i : target) {
                System.out.printf("%d ", i);
            }
        } else {
            System.out.println(-1);
        }
    }

    static boolean solve() {
        int i = n - 1;
        while (i > 0 && target[i - 1] > target[i]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }
        int j = n - 1;
        while (target[j] < target[i - 1]) {
            j--;
        }
        swap(i - 1, j);
        j = n - 1;
        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }
        return true;
    }

    private static void swap(int i, int j) {
        int tmp = target[j];
        target[j] = target[i];
        target[i] = tmp;
    }
}
