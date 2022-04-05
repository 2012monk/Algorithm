package BOJ.N14500테트로미노;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static int[][] grid;
    static int N, M;

    static int[][][] blocks = {
        {{0, 0}, {0, 1}, {1, 0}, {1, 1}}, // O
        {{0, 0}, {0, 1}, {0, 2}, {0, 3}}, // I rotate 1
        {{0, 0}, {0, 1}, {0, 2}, {1, 2}}, // L rotate 3
        {{0, 0}, {0, 1}, {0, 2}, {1, 0}}, // J rotate 3
        {{0, 0}, {1, 0}, {1, 1}, {2, 1}}, // S rotate 1
        {{0, 0}, {0, 1}, {1, 1}, {1, 2}}, // Z rotate 1
        {{0, 0}, {0, 1}, {0, 2}, {1, 1}} // T rotate 3
    };
    static int[] rotateCount = {0, 1, 3, 3, 1, 1, 3};

    public static void main(String[] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());

        grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(stz.nextToken());
            }
        }

        System.out.println(solve());
    }

    public static int solve() {
        int result = 0;
        for (int i = 0; i < 7; i++) {
            int[][] b = blocks[i];
            result = Math.max(result, count(b));
            for (int j = 0; j < rotateCount[i]; j++) {
                b = rotate(b);
                result = Math.max(result, count(b));
            }
        }
        return result;
    }

    private static int count(int[][] b) {
        int[] topLeft = topLeftCorner(b);
        int x = topLeft[0], y = topLeft[1];
        int ans = 0;
        while (true) {
            if (isValid(b, x, y)) {
                ans = Math.max(ans, sum(b, x, y));
                y++;
                continue;
            }
            ++x;
            y = topLeft[1];
            if (!isValid(b, x, y)) {
                break;
            }
        }
        return ans;
    }

    private static int sum(int[][] b, int x, int y) {
        int ret = 0;
        for (int[] co : b) {
            ret += grid[x + co[0]][y + co[1]];
        }
        return ret;
    }

    private static boolean isValid(int[][] b, int x, int y) {
        for (int[] co : b) {
            int dx = x + co[0], dy = y + co[1];
            if (dx < 0 || dx >= N || dy < 0 || dy >= M) {
                return false;
            }
        }
        return true;
    }

    private static int[] topLeftCorner(int[][] b) {
        int x = N, y = M;
        for (int[] c : b) {
            x = Math.min(x, c[0]);
            y = Math.min(y, c[1]);
        }
        return new int[]{-x, -y};
    }

    public static int[][] rotate(int[][] b) {
        int[][] tmp = new int[4][2];
        for (int i = 0; i < 4; i++) {
            tmp[i][0] = -b[i][1];
            tmp[i][1] = b[i][0];
        }
        return tmp;
    }
}
