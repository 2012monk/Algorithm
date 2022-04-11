package BOJ.N10974모든순열;

import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int n;
    static boolean[] v;
    static int[] path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        n = Integer.parseInt(br.readLine());
        v = new boolean[n + 1];
        path = new int[n];
        solve(0);
        System.out.println(sb);
    }

    static void solve(int x) {
        if (x == n) {
            for (int i : path) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (v[i]) continue;
            v[i] = true;
            path[x] = i;
            solve(x + 1);
            v[i] = false;
        }
    }
}
