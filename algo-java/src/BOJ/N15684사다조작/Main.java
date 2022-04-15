package BOJ.N15684사다조작;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] ladders = new int[10][31];
    static int n,m,h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        h = Integer.parseInt(stz.nextToken());
        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            ladders[b - 1][a - 1] = 1;
            ladders[b][a - 1] = -1;
        }
        if (betweenOdd() > 3) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (solve(0,0,i)) return;
        }
        System.out.println(-1);
    }

    static boolean solve(int p, int count, int limit) {
        if (count == limit) {
            if (isAnswer()) {
                System.out.println(count);
                return true;
            }
            return false;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < h; j++) {
                if (ladders[i][j] != 0 || ladders[i + 1][j] != 0) continue;
                ladders[i][j] = 1;
                ladders[i + 1][j] = -1;
                if (solve(p + 1, count + 1, limit)) {
                    return true;
                }
                ladders[i][j] = ladders[i + 1][j] = 0;
            }
        }
        return false;
    }

    static boolean isAnswer() {
        for (int i = 0; i < n; i++) {
            int c = i;
            for (int j = 0; j < h; j++) {
                c += ladders[c][j];
            }
            if (c != i) return false;
        }
        return true;
    }

    public static int betweenOdd() {
        int odd = 0;
        for (int i = 0; i < n - 1; i++) {
            int temp = 0;
            for (int row = 0; row < h; row++) {
                if (ladders[i][row] == 1) temp++;
            }
            if (temp % 2 == 1) odd++;
        }
        return odd;
    }
}
