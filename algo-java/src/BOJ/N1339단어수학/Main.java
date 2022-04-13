package BOJ.N1339단어수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] map = new int[27];
    static String[] grid;
    static int n, ans = Integer.MIN_VALUE, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Arrays.fill(map, -1);
        grid = new String[n];
        count = 0;
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine();
            for (char c : grid[i].toCharArray()) {
                if (map[c-'A'] != -1) continue;
                map[c-'A'] = count++;
            }
        }
        solve(0, 0, new int[count]);
        System.out.println(ans);
    }

    static void solve(int x, int v, int[] path) {
        if (x == count) {
            f(path);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if ((v&(1<<i))!=0) {
                continue;
            }
            path[x] = i;
            solve(x+1, v | (1 << i), path);
        }
    }

    static void f(int[] path) {
        int total = 0, sum;
        for (String s : grid) {
            sum = 0;
            for (char c : s.toCharArray()) {
                sum = sum * 10 + path[map[c-'A']];
            }
            total += sum;
        }
        ans = Math.max(ans, total);
    }
}
