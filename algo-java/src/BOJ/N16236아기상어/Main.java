package BOJ.N16236아기상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static int[] board = new int[401];
    static int N, ans;

    static boolean isOutBound(int x, int d) {
        int i = x / N + d / N;
        int j = x % N + d % N;
        return i < 0 || i >= N || j < 0 || j >= N;
    }

    static boolean isPrior(int dx, int mi, int dist, int next) {
        if (mi < dist)
            return false;
        if (mi > dist)
            return true;
        return dx < next;
    }

    static int move(int s, int size) {
        int[] v = new int[401];
        int mi = Integer.MAX_VALUE;
        int next = -1;
        int[] d = {1, -1, N, -N};
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(s);
        v[s] = 1;

        while (!q.isEmpty()) {
            int x = q.removeFirst();
            for (int j = 0; j < 4; j++) {
                int dx = d[j] + x;
                if (isOutBound(x, d[j]))
                    continue;
                if (v[dx] != 0 || board[dx] > size)
                    continue;
                v[dx] = v[x] + 1;
                if (board[dx] != 0 && board[dx] < size && isPrior(dx, mi, v[dx], next)) {
                    mi = v[dx];
                    next = dx;
                }
                q.add(dx);
            }
        }
        if (mi != Integer.MAX_VALUE)
            ans += mi - 1;
        return next;
    }

    static int eat(int s) {
        int ret = 0, st = 0, size = 2;
        int next;
        while ((next = move(s, size)) != -1) {
            board[s = next] = 0;
            if (++st == size){
                ++size;
                st = 0;
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        int s = 0;
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i * N + j] = Integer.parseInt(stz.nextToken());
                if (board[i * N + j] == 9) {
                    board[i * N + j] = 0;
                    s = i * N + j;
                }
            }
        }
        board[s] = 0;
        eat(s);
        System.out.println(ans);
    }
}
