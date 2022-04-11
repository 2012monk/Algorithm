package BOJ.N15666N과M12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer stz;
    static StringBuffer sb = new StringBuffer();
    static int n, m, N;
    static int[] numbers, path;
    static boolean[] element = new boolean[10001];

    public static void main(String[] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        path = new int[m];
        numbers = new int[n];
        stz = new StringTokenizer(br.readLine());
        N = 0;
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(stz.nextToken());
            if (element[t]) {
                continue;
            }
            numbers[N++] = t;
            element[t] = true;
        }
        Arrays.sort(numbers, 0, N);
        solve(0, 0);
        bw.write(sb.toString());
        bw.flush();
    }

    static void solve(int x, int start) {
        if (x == m) {
            for (int i : path) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = start; i < N; i++) {
            path[x] = numbers[i];
            solve(x + 1, i);
        }
    }
}
