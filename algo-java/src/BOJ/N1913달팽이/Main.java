package BOJ.N1913달팽이;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());

        int[][] b = new int[n][n];
        int[] nx = {-1, 0, 1, 0};
        int[] ny = {0, 1, 0, -1};

        int x = n / 2, y = n / 2;
        int d = 0, cnt = 1, s = 1, cur = 1;
        int flag = 1;
        b[x][y] = cnt;

        while (!(x == 0 && y == 0)) {
            x += nx[d];
            y += ny[d];
            b[x][y] = ++cnt;
            if (--cur == 0) {
                d = (d + 1) % 4;
                s += (flag = 1 ^ flag);
                cur = s;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(String.valueOf(b[i][j]));
                if (j == n - 1)
                    bw.write("\n");
                else
                    bw.write(" ");
                if (b[i][j] == t) {
                    x = i + 1;
                    y = j + 1;
                }
            }
        }
        bw.write(x + " " + y);
        bw.flush();
        bw.close();
    }
}
