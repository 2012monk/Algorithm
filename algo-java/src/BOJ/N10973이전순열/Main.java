package BOJ.N10973이전순열;

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
        StringBuffer sb = new StringBuffer();
        n = Integer.parseInt(br.readLine());
        target = new int[n];
        stz = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            target[i] = Integer.parseInt(stz.nextToken());
        }
        if (solve()) {
            for (int i : target) {
                sb.append(i).append(" ");
            }
        } else {
            sb.append(-1);
        }
        System.out.println(sb);
    }

    public static boolean solve() {
        int i = n - 1;
        int j = n - 1;
        while (i > 0 && target[i] > target[i - 1]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }

        while (target[j] > target[i - 1]) {
            j--;
        }
        swap(i - 1, j);
        j = n - 1;
        while (i < j) {
            swap(i++, j--);
        }

        return true;
    }

    private static void swap(int i, int j) {
        int tmp = target[j];
        target[j] = target[i];
        target[i] = tmp;
    }
}
