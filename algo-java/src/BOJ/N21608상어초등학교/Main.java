package BOJ.N21608상어초등학교;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int[][] board = new int[20][20];
    static int N;
    static Map<Integer, Set<Integer>> map = new HashMap<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static void deploy(int s) {
        ArrayList<int[]> a = new ArrayList<>();
        fillCand(a, map.get(s));

        a.sort((a1, a2) -> {
            for (int i = 0; i < 2; i++) {
                if (a1[i] != a2[i]) {
                    return a2[i] - a1[i];
                }
            }
            return a1[2] - a2[2];
        });
        int x = a.get(0)[2] / N;
        int y = a.get(0)[2] % N;
        board[x][y] = s;
    }

    static void fillCand(ArrayList<int[]> a, Set<Integer> s) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 0) {
                    continue;
                }
                a.add(count(i, j, s));
            }
        }
    }

    static int[] count(int x, int y, Set<Integer> s) {
        int[] nx = {0, 0, 1, -1};
        int[] ny = {1, -1, 0, 0};
        int[] r = new int[3];
        r[2] = x * N + y;

        for (int i = 0; i < 4; i++) {
            int dx = nx[i] + x;
            int dy = ny[i] + y;
            if (dx < 0 || dx >= N || dy < 0 || dy >= N) {
                continue;
            }
            if (board[dx][dy] == 0) {
                r[1]++;
            } else if (s.contains(board[dx][dy])) {
                r[0]++;
            }
        }
        return r;
    }

    static int calculate() {
        int ret = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int p = count(i, j, map.get(board[i][j]))[0];
                if (p == 0) {
                    continue;
                }
                ret += Math.pow(10, p - 1);
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        Set<Integer> s;

        for (int i = 1; i <= N * N; i++) {
            stz = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stz.nextToken());
            s = new HashSet<>();
            for (int j = 0; j < 4; j++) {
                s.add(Integer.parseInt(stz.nextToken()));
            }
            map.put(x, s);
            deploy(x);
        }
        System.out.println(calculate());
    }
}