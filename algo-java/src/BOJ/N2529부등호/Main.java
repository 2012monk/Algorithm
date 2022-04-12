package BOJ.N2529부등호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final StringBuffer sb = new StringBuffer();
    static int n;
    static boolean[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        map = new boolean[n + 1];
        int[] forward = new int[10], backward = new int[10];
        stz = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            map[i] = stz.nextToken().equals("<");
        }
        for (int i = 0; i < 10; i++) {
            forward[i] = backward[9 - i] = i;
        }
        find(0, backward, new int[n + 1], new boolean[10]);
        find(0, forward, new int[n + 1], new boolean[10]);
        System.out.println(sb);
    }

    static boolean find(int x, int[] nu, int[] path, boolean[] v) {
        if (x > n) {
            for (int i : path) {
                sb.append(i);
            }
            sb.append('\n');
            return true;
        }
        for (int idx = 0; idx < 10; idx++) {
            int i = nu[idx];
            if (v[i] || !isValid(x - 1, i, path)) {
                continue;
            }
            v[i] = true;
            path[x] = i;
            if (find(x + 1, nu, path, v)) {
                return true;
            }
            v[i] = false;

        }
        return false;
    }

    static boolean isValid(int i, int val, int[] path) {
        if (i < 0) {
            return true;
        }
        if (map[i]) {
            return path[i] < val;
        }
        return path[i] > val;
    }
}
