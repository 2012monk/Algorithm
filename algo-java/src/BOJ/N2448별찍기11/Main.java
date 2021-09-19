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
        if (size == 1) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    board[i+x][j+y] = board[i][j];
                }
            }
            return;
        }
        star(x, y+3*size/2, size>>1);
        star(x+3*size/2, y, size>>1);
        star(x+3*size/2, y+3*size/2, size>>1);
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        board = new int[n][n*2];
        star(0, 0, n);
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
