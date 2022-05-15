package BOJ.N2251물통;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] buckets = new int[3];
    static boolean[] check = new boolean[201];
    static boolean[][] v = new boolean[201][201];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        buckets[0] = Integer.parseInt(stz.nextToken());
        buckets[1] = Integer.parseInt(stz.nextToken());
        buckets[2] = Integer.parseInt(stz.nextToken());
        solve(new int[]{0,0,buckets[2]});
        for (int i = 0; i < check.length; i++) {
            if (!check[i]) continue;
            System.out.printf("%d ", i);
        }
    }

    static void solve(int[] b) {
        if (v[b[0]][b[1]]) {
            return;
        }
        if (b[0] == 0) {
            check[b[2]] = true;
        }
        v[b[0]][b[1]] = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) continue;
                // i -> j
                int t = b[i] + b[j];
                int[] nb = Arrays.copyOf(b, 3);
                if (t > buckets[j]) {
                    nb[i] = t - buckets[j];
                    nb[j] = buckets[j];
                } else {
                    nb[i] = 0;
                    nb[j] = t;
                }
                solve(nb);
            }
        }
    }
}
