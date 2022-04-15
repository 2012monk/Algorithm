package BOJ.N17085십자가2개놓기;

import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] grid = new boolean[16][16];
    static int n, m;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(j) == '#';
            }
        }
        solve(1, 0, 1);
        System.out.println(ans);
    }

    static void solve(int p, int count, long total) {
        int x = p / m, y = p % m;
        if (x >= n - 1 || count == 2) {
            ans = max(ans, total);
            return;
        }
        if (!grid[x][y] || p == m - 1) {
            solve(p + 1, count, total);
            return;
        }
        int size = 3;
        int space;
        while (isValid(x, y, size)) {
            space = size * 2 - 1;
            mark(x, y, size);
            solve(p + 1, count + 1, total * space);
            unMark(x, y, size);
            size += 2;
        }
        solve(p + 1, count, total);
    }

    private static void mark(int x, int y, int size) {
        for (int i = -size / 2; i <= size / 2; i++) {
            grid[x + i][y] = grid[x][y + i] = false;
        }
    }

    private static void unMark(int x, int y, int size) {
        for (int i = -size / 2; i <= size / 2; i++) {
            grid[x + i][y] = grid[x][y + i] = true;
        }
    }

    private static boolean isValid(int x, int y, int size) {
        for (int i = -(size / 2); i <= size / 2; i++) {
            if (isInvalid(x + i, y) || isInvalid(x, y + i)) {
                return false;
            }
        }
        return true;
    }

    static boolean isInvalid(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < m) {
            return !grid[x][y];
        }
        return true;
    }
}
