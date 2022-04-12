package BOJ.N15661링크와스타트;

import static java.lang.Math.abs;
import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static boolean[] v;
    static int[] left, right;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        int total = 0;
        map = new int[n][n];
        v = new boolean[n];
        left = new int[n];
        right = new int[n];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int t = Integer.parseInt(stz.nextToken());
                map[i][j] = t;
                total += t;
                left[i] += t;
                right[j] += t;
            }
        }
//        System.out.println(find(0, 0, 0));
        System.out.println(find(0, 0, total, n / 2 + n % 2));
    }

    static int find(int x, int count, int total, int limit) {
        if (count == limit) {
            return abs(total);
        }
        if (x >= n) {
            return Integer.MAX_VALUE;
        }
        int ret = min(find(x + 1, count + 1, total - left[x] - right[x], limit),
            find(x + 1, count, total, limit));
        return min(ret, abs(total));
    }

    static int bruteForce(int number, int count) {
        if (count == n / 2 + n % 2) {
            return diff();
        }
        if (number >= n) {
            return Integer.MAX_VALUE;
        }
        v[number] = true;
        int ret = diff();
        ret = min(ret, bruteForce(number + 1, count + 1));
        v[number] = false;
        return min(ret, bruteForce(number + 1, count));
    }

    private static int diff() {
        int l = 0, r = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (v[i] && v[j]) {
                    l += map[i][j] + map[j][i];
                }
                if (!v[i] && !v[j]) {
                    r += map[i][j] + map[j][i];
                }
            }
        }
        return abs(l - r);
    }
}
