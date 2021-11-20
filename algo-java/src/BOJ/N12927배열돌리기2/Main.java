package BOJ.N12927배열돌리기2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer stz;
    static int[][] b;


    static void rotate(int x, int y, int n, int m) {
        int[] nx = {0, 1, 0, -1};
        int[] ny = {1, 0, -1, 0};

        int cnt = n * 2 + m * 2 - 4;
        int s = m, cur = m;
        int d = 0;
        int start = b[x][y];

        while (cnt-- > 1) {
            b[x][y] = b[x + nx[d]][y + ny[d]];
            x += nx[d];
            y += ny[d];
            if (--cur == 1) {
                d = (d + 1) % 4;
                if (s == n)
                    s = m;
                else
                    s = n;
                cur = s;
            }
        }
        b[x][y] = start;
    }

    public static void main(String[] args) throws IOException {
        int N, M, R;
        stz = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());
        R = Integer.parseInt(stz.nextToken());
        b = new int[N][M];

        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                b[i][j] = Integer.parseInt(stz.nextToken());
            }
        }

        for (int i = 0; i < N / 2 && i < M / 2; i++) {
            int xb = N - i * 2;
            int yb = M - i * 2;
            int size = xb * 2 + yb * 2 - 4;
            if (size == 0)
                continue;
            for (int j = 0; j < R % size; j++) {
                rotate(i, i, xb, yb);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write(String.valueOf(b[i][j]));
                if (j < M - 1)
                    bw.write(" ");
                else
                    bw.write("\n");
            }
        }
        bw.flush();
    }


}
