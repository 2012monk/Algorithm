package BOJ.N20057마법사상어와토네이도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static int[][] board;
    static int N;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] wind = new int[][] { // spread
                      {2, 0, 2},
        {1, -1, 10},  {1, 0, 7},  {1, 1, 1},
        {0, -2, 5},
        {-1, -1, 10}, {-1, 0, 7}, {-1, 1, 1},
                      {-2, 0, 2},
        {0, -1, 55} // a 자리의 양 마지막에 계산
    };

    static int[] rotate(int[] s, int cnt) {
        int[] ret = Arrays.copyOf(s, 3);
        int x = s[0];
        int y = s[1];
        int tmp;
        for (int i = 0; i < cnt; i++) {
            tmp = x;
            x = -y;
            y = tmp;
        }
        ret[0] = x;
        ret[1] = y;
        return ret;
    }

    static int moveSand(int x, int y, int dir) {
        int nx, ny, amount, subTotal = 0, ret = 0, total = board[x][y];
        int[] d;

        for (int i = 0; i < 10; i++) {
            d = rotate(wind[i], dir);
            nx = d[0] + x;
            ny = d[1] + y;
            amount = total * d[2] / 100;
            if (i == 9)
                amount = total - ret - subTotal;
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                ret += amount;
                continue;
            }
            board[nx][ny] += amount;
            subTotal += amount;
        }
        board[x][y] = 0;
        return ret;
    }

    static int solve(int x, int y) {
        int ret = 0, cnt = 1, dir = 0;
        boolean flag = false;

        while (!(x == 0 && y == 0)) {
            for (int j = 0; j < cnt; j++) {
                x = x + dx[dir];
                y = y + dy[dir];
                ret += moveSand(x, y, dir);
                if (x == 0 && y == 0)
                    break;
            }
            dir = (dir + 1) % 4;
            if (flag)
                cnt++;
            flag = !flag;
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
    board = new int[N][N];
        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(stz.nextToken());
            }
        }
        System.out.println(solve(N / 2, N / 2));
    }
}
