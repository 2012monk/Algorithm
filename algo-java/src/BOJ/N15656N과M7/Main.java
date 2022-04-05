package BOJ.N15656N과M7;

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
        solve(0);
        bw.write(sb.toString());
        bw.flush();
    }

    static void solve(int x) {
        if (x == m) {
            sb.append(String.join(" ", path)).append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            path[x] = String.valueOf(numbers[i]);
            solve(x + 1);
        }
    }
}
