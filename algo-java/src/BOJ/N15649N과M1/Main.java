package BOJ.N15649N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static StringBuffer sb = new StringBuffer();
    static boolean[] v;
    static char[] path;
    static int n, m;

    public static void main(String[] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        v = new boolean[n + 1];
        path = new char[m * 2 + 1];
        Arrays.fill(path, ' ');
        path[m * 2] = '\n';

        solve(0);
        System.out.println(sb);
    }

    private static void solve(int cur) {
        if (cur == m) {
            sb.append(path);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (v[i]) {
                continue;
            }
            v[i] = true;
            path[cur*2] = (char) (i + '0');
            solve(cur + 1);
            v[i] = false;
        }
    }
}
