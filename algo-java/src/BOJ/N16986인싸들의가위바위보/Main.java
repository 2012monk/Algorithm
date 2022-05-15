package BOJ.N16986인싸들의가위바위보;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] operations = new int[9][9];
    static int[] wins = new int[3];
    static int n, k;
    static boolean[] v = new boolean[9];
    static Seq[] seq = new Seq[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        seq[0] = new Seq(new int[n]);
        seq[1] = new Seq(new int[20]);
        seq[2] = new Seq(new int[20]);
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                operations[i][j] = Integer.parseInt(stz.nextToken());
            }
        }

        for (int i = 1; i <= 2; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < 20; j++) {
                seq[i].arr[j] = Integer.parseInt(stz.nextToken()) - 1;
            }
        }
        System.out.println(solve(0));
    }

    static void getWinner(int a, int b) {
        int nextA = seq[a].next();
        int nextB = seq[b].next();
        if (nextA < 0 || nextB < 0) {
            return;
        }
        int res = operations[nextA][nextB];
        int winner = b;
        if (res == 1) {
            winner = Math.max(a, b);
        }
        if (res == 2) {
            winner = a;
        }
        wins[winner]++;
        if (wins[winner] == k) {
            return;
        }
        getWinner(winner, 3 - a - b);
    }

    static int solve(int x) {
        if (x == n) {
            findWinner();
            if (wins[0] == k) {
                return 1;
            }
            return 0;
        }
        for (int i = 0; i < n; i++) {
            if (v[i]) {
                continue;
            }
            v[i] = true;
            seq[0].arr[x] = i;
            if (solve(x + 1) == 1) {
                return 1;
            }
            v[i] = false;
        }
        return 0;
    }

    static void findWinner() {
        seq[0].reset();
        seq[1].reset();
        seq[2].reset();
        Arrays.fill(wins, 0);
        getWinner(0, 1);
    }

    static class Seq {
        int[] arr;
        int head = 0;
        public Seq(int[] a) {
            this.arr = a;
        }

        void reset() {
            this.head = 0;
        }

        int next() {
            if (head >= arr.length) {
                return -1;
            }
            return arr[head++];
        }
    }
}
