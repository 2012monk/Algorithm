package BOJ.N1080행렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == '1') a[i][j] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                int k = s.charAt(j) - '0';
                if (a[i][j] != k) a[i][j] = 1;
                else a[i][j] = 0;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != 1) continue;
                if (i > n - 3 || j > m - 3){
                    System.out.println(-1);
                    return;
                }
                flip(a, i, j);
                ans++;
            }
        }
        System.out.println(ans);
    }

    static void flip(int[][] a, int x, int y) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[i + x][j + y] = 1 ^ a[i + x][j + y];
            }
        }
    }
}
