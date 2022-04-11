package BOJ.N6603로또;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, MAX = 6;
    static int[] numbers, path;
    static boolean[] v;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        while (true) {
            stz = new StringTokenizer(br.readLine());
            n = Integer.parseInt(stz.nextToken());
            numbers = new int[n];
            path = new int[MAX];
            v = new boolean[n];
            if (n == 0) {
                break;
            }
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(stz.nextToken());
            }
            solve(0, 0, 0);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void solve(int x, int y, int count) {
        if (count == MAX) {
            for (int i : path) {
                sb.append(i).append(' ');
            }
            sb.append("\n");
            return;
        }
        if (x >= MAX || y >= n) {
            return;
        }
        path[x] = numbers[y];
        solve(x + 1, y + 1, count + 1);
        solve(x, y + 1, count);
    }
}
