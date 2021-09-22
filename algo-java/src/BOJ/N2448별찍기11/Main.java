package BOJ.N2448별찍기11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[][] board;
    static int[][] tree = {
        {0,0,1,0,0},
        {0,1,0,1,0},
        {1,1,1,1,1}
    };

    static void star(int x, int y, int size) {
        if (size == 3) {
            for (int i = x; i >= x-2; i--) {
                System.arraycopy(tree[i - x + 2], 0, board[i], y, y + 5 - y);
            }
            return;
        }
        star(x, y, size>>1);
        star(x-(size>>1), y+(size>>1),size>>1);
        star(x, y+size,size>>1);
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        board = new int[n][n*2];
        star(n-1, 0, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 2; j++) {
                if (board[i][j] == 1) bw.write('*');
                else bw.write(' ');
            }
            bw.write('\n');
        }
        bw.flush();
    }


}
