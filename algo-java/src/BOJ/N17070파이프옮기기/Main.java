package BOJ.N17070파이프옮기기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] grid;
    static int[][] d = {
        {0,1},{1,0},{1,1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(stz.nextToken());
            }
        }
        System.out.println(find(0,1,0));
    }

    static int find(int x, int y, int pos) {
        if (x == n - 1 && y == n - 1) return 1;
        int ret = 0;
        for (int i = 0; i < 3; i++) {
            if ((i == 0 && pos == 1) || (i == 1 && pos == 0)) continue;
            int dx = x + d[i][0];
            int dy = y + d[i][1];
            if (isInvalid(dx, dy)) continue;
            if (i == 2 && (isInvalid(x + 1, y) || isInvalid(x, y + 1))) continue;
            ret += find(dx, dy, i);
        }
        return ret;
    }

    static boolean isInvalid(int x, int y) {
        if (0 <= x && x < n && 0 <= y && y < n){
            return grid[x][y] != 0;
        }
        return true;
    }
}
