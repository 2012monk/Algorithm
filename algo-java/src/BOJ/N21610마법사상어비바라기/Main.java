package BOJ.N21610마법사상어비바라기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static ArrayDeque<Integer> clouds = new ArrayDeque<>();
    static Set<Integer> tmp = new HashSet<>();
    static int[] board;
    static int[][] moves;
    static int[] nx;
    static int[] ny;
    static int N, M;

    static void move(int dir, int speed) {
        int x, y, l, size = clouds.size();

        for (int i = 0; i < size; i++) {
            l = clouds.pop();
            x = (l / N + nx[dir] * speed) % N;
            y = (l % N + ny[dir] * speed) % N;
            l = x * N + y;
            board[l]++;
            tmp.add(l);
        }

        for (Integer i : tmp) {
            water(i);
        }
    }

    static void water(int s) {
        int[][] d = {{1 , 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int x = s / N , y = s % N;
        int dx, dy;

        for (int i = 0; i < 4; i++) {
            dx = x + d[i][0];
            dy = y + d[i][1];
            if (dx < 0 || dx >= N || dy < 0 || dy >= N)
                continue;
            if (board[dx * N + dy] < 1)
                continue;
            board[s]++;
        }
    }

    static void newCloud() {
        for (int i = 0; i < N * N; i++) {
            if (tmp.contains(i) || board[i] < 2)
                continue;
            clouds.add(i);
            board[i] -= 2;
        }
        tmp.clear();
    }

    static void print(boolean isCloud) {
        System.out.println();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isCloud){
                    if (clouds.contains(i * N + j))
                        System.out.printf("%d* ", board[i * N + j]);
                    else
                        System.out.printf("%d ", board[i * N + j]);
                }
                else {
                    if (tmp.contains(i * N + j))
                        System.out.printf("%d* ", board[i * N + j]);
                    else
                        System.out.printf("%d ", board[i * N + j]);
                }
            }
            System.out.println();
        }
    }

    static int solve() {

        for (int[] m : moves) {
            move(m[0], m[1]);
            newCloud();
        }

        return Arrays.stream(board).sum();
    }

    public static void main(String[] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());
        board = new int[N*N];
        moves = new int[M][2];

        nx = new int[]{ 0, N - 1, N - 1, N - 1, 0, 1, 1, 1};
        ny = new int[]{ N - 1, N - 1, 0, 1, 1, 1, 0, N - 1};

        for (int i = 0; i < N * N; i++) {
            if (i % N == 0)
                stz = new StringTokenizer(br.readLine());
            board[i] = Integer.parseInt(stz.nextToken());
        }

        for (int i = 0; i < M; i++) {
            stz = new StringTokenizer(br.readLine());
            moves[i][0] = Integer.parseInt(stz.nextToken()) - 1;
            moves[i][1] = Integer.parseInt(stz.nextToken());
        }

        for (int i = 1; i < 3; i++) {
            clouds.add(N * (N - i));
            clouds.add(N * (N - i) + 1);
        }

        System.out.println(solve());
    }

}
