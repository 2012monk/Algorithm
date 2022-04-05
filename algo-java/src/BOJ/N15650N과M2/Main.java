package BOJ.N15650N과M2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static int n, m;
    static boolean[] v;
    static StringBuffer sb = new StringBuffer();
    static char[] path;

    public static void main(String[] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        v = new boolean[n + 1];
        path = new char[m * 2 + 1];
        Arrays.fill(path, ' ');
        path[m * 2] = '\n';
        solve(0, 1, 0);
        System.out.println(sb);
    }

    public static void solve(int cur, int x, int count) {
        if (count == m) {
            sb.append(path);
            return;
        }
        if (cur >= m || x > n) {
            return;
        }
        path[cur * 2] = (char) (x + '0');
        solve(cur + 1, x + 1, count + 1);
        solve(cur, x + 1, count);
    }
}
