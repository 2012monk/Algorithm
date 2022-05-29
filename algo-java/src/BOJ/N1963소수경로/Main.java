package BOJ.N1963소수경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] prime = new boolean[100000];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int t = Integer.parseInt(br.readLine());
        sieve();
        while (t-- > 0) {
            stz = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stz.nextToken());
            int k = Integer.parseInt(stz.nextToken());
            System.out.println(bfs(n, k));
        }
    }

    static String bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        int[] v = new int[10000];
        q.add(n);
        v[n] = 1;
        while (!q.isEmpty()) {
            int x = q.poll();
            if (x == k) {
                return String.valueOf(v[x] - 1);
            }
            for (int d = 1; d <= 1000; d *= 10) {
                int digit = x - ((x % (d * 10)) / d) * d;
                for (int j = 0; j < 10; j++) {
                    int r = digit + d * j;
                    if (r < 1000) continue;
                    if (!prime[r] || v[r] != 0) continue;
                    v[r] = v[x] + 1;
                    q.add(r);
                }
            }
        }
        return "Impossible";
    }

    static void sieve() {
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i < 100; i++) {
            if (!prime[i]) continue;
            for (int j = i + i; j < 10000 ; j+= i) {
                prime[j] = false;
            }
        }
    }
}
