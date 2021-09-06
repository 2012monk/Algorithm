package BOJ.N2267단지번호붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer> r = new ArrayList<>();
    static boolean[][] b;
    static int[][] dt = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int n;


    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!b[i][j]) {
                    continue;
                }
                b[i][j] = false;
                r.add(dfs(i, j));
            }
        }
        Collections.sort(r);
        System.out.println(r.size());
        StringBuilder sb = new StringBuilder();
        for (Integer i : r) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }


    static int dfs(int x, int y) {
        int r = 1;
        for (int[] d : dt) {
            int dx = d[0] + x;
            int dy = d[1] + y;
            if (dx < 0 || dx >= n || dy < 0 || dy >= n) {
                continue;
            }
            if (!b[dx][dy]) {
                continue;
            }
            b[dx][dy] = false;
            r += dfs(dx, dy);
        }
        return r;
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        b = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == '1') {
                    b[i][j] = true;
                }
            }
        }
    }
}
