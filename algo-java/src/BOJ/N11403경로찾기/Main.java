package BOJ.N11403경로찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] g = new int[101][101];
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                g[i][j] = Integer.parseInt(stz.nextToken());
            }
        }
        floydWarshall();
        print();
    }

    static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", g[i][j]);
            }
            System.out.println();
        }
    }

    static void floydWarshall() {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (g[i][j] == 1) continue;
                    if (g[i][k] == 1 && g[k][j] == 1) {
                        g[i][j] = 1;
                    }
                }
            }
        }
    }
}
