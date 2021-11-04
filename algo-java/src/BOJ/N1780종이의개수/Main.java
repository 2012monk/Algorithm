package BOJ.N1780종이의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static int[][] board;
    static int n;
    static int[] res = new int[3];

    static void find(int x, int y, int size) {
        if (size == 1 || check(x,y,size)) {
            res[board[x][y]+1]++;
            return;
        }
        size /= 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                find(x + size * i, y + size * j, size);
            }
        }
    }

    static boolean check(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (board[i][j] != board[x][y]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(stz.nextToken());
            }
        }
        find(0,0, n);
        for (int i = 0; i < 3; i++) {
            System.out.println(res[i]);
        }
    }


}
