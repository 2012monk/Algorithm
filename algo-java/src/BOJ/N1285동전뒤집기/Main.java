package BOJ.N1285동전뒤집기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static boolean[][] tails;
    static int[] v;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tails = new boolean[n][n];
        v = new int[1 << n];
        Arrays.fill(v, -1);
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                tails[i][j] = s.charAt(j) == 'T';
            }
        }
        System.out.println(f(0));
    }

    static int f(int idx) {
        if (idx == n) return count();
        int ret = f(idx + 1);
        flipHorizontal(idx);
        return Math.min(ret, f(idx + 1));
    }

    static int count() {
        int ret = 0, cnt;
        for (int j = 0; j < n; j++) {
            cnt = 0;
            for (int i = 0; i < n; i++) {
                if (tails[i][j]) cnt++;
            }
            ret += Math.min(cnt, n - cnt);
        }
        return ret;
    }

    static void flipHorizontal(int x) {
        for (int i = 0; i < n; i++) {
            tails[x][i] = !tails[x][i];
        }
    }
}
