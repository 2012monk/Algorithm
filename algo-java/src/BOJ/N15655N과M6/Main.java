package BOJ.N15655N과M6;

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
    static String[] path;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        numbers = new int[n];
        path = new String[m];
        stz = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(stz.nextToken());
        }
        Arrays.sort(numbers);
        solve(0, 0);
        System.out.println(sb);
    }

    static void solve(int x, int start) {
        if (x == m) {
            sb.append(String.join(" ", path)).append("\n");
            return;
        }
        for (int i = start; i < n; i++) {
            path[x] = String.valueOf(numbers[i]);
            solve(x + 1, i + 1);
        }
    }
}
