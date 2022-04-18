package BOJ.N4902삼각형의값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] triangle, pSum;
    static int n;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        while (solution());
    }

    static boolean solution() throws IOException {
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        if (n == 0) {
            return false;
        }
        triangle = new int[n + 1][n * 2];
        pSum = new int[n + 1][n * 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i * 2 - 1; j++) {
                triangle[i][j] = Integer.parseInt(stz.nextToken());
                pSum[i][j] += pSum[i][j - 1] + triangle[i][j];
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i * 2 - 1; j += 2) {
                int current = 0;
                for (int k = 0; k < n - i + 1; k++) {
                    current += pSum[i + k][j + 2 * k] - pSum[i + k][j - 1];
                    ans = Math.max(ans, current);
                }
            }
        }

        for (int i = n; i >= 1; i--) {
            for (int j = 2; j <= i * 2 - 1; j += 2) {
                int current = 0;
                for (int k = 0; k < Math.min(j / 2, i - j / 2); k++) {
                    current += pSum[i - k][j] - pSum[i - k][j - 2 * k - 1];
                    ans = Math.max(ans, current);
                }
            }
        }
        System.out.println(count++ + ". "+ans);
        return true;
    }
}