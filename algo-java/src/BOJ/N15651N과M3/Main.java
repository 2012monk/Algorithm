package BOJ.N15651N과M3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static StringBuffer sb = new StringBuffer();
    static int n, m;
    static char[] path;

    public static void main(String[] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        path = new char[m * 2 + 1];
        Arrays.fill(path, ' ');
        path[m * 2] = '\n';
        solve(0, 0);
        System.out.println(sb);
    }

    private static void solve(int x, int c) {
        if (c == m) {
            sb.append(path);
            return;
        }
        for (int i = 1; i <= n; i++) {
            path[x * 2] = (char) (i + '0');
            solve(x + 1, c + 1);
        }
    }
}
