package BOJ.N15664N과M10;

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
    static int n, m;
    static int[] numbers, path;
    static StringBuffer sb = new StringBuffer();
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        numbers = new int[n];
        path = new int[m];
        v = new boolean[n];
        stz = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(stz.nextToken());
        }
        Arrays.sort(numbers);
        solve(0, 0, 0);
        bw.write(sb.toString());
        bw.flush();
    }

    static void solve(int x, int start, int count) {
        if (count == m) {
            for (int i : path) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        int prev = 0;
        for (int i = start; i < n; i++) {
            if (v[i] || prev == numbers[i]) {
                continue;
            }
            v[i] = true;
            path[x] = numbers[i];
            solve(x + 1, i, count + 1);
            prev = numbers[i];
            v[i] = false;
        }
    }
}
