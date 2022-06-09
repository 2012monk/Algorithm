package BOJ.N1507궁금한민호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] dist;
    static boolean[][] unused;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        dist = new int[n][n];
        unused = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.parseInt(stz.nextToken());
            }
        }
        System.out.println(solve());
    }

    static int solve() {
        if (!floyd()) return -1;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (unused[i][j]) continue;
                ret += dist[i][j];
            }
        }
        return ret;
    }

    static boolean floyd() {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j || i == k || j == k) continue;
                    if (dist[i][j] == dist[i][k] + dist[k][j]) {
                        unused[i][j] = true;
                    }
                    if (dist[i][j] > dist[i][k] + dist[k][j]) return false;
                }
            }
        }
        return true;
    }
}
