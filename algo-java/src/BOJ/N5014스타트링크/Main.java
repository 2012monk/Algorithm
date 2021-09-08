package BOJ.N5014스타트링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static int[] dist, dt;
    static int n, s,target;
    static Queue<Integer> Q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        init();
        Q.offer(s);
        dist[s] = 1;
        while (!Q.isEmpty()) {
            int cur = Q.poll();
            if (cur == target) {
                System.out.println(dist[cur]-1);
                return;
            }
            for (int d : dt) {
                int x = cur+d;
                if (x < 1 || x > n) continue;
                if (dist[x] != 0) continue;
                dist[x] = dist[cur]+1;
                Q.offer(x);
            }
        }
        System.out.println("use the stairs");
    }

    static void init() throws IOException {
        dt = new int[2];
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        s = Integer.parseInt(stz.nextToken());
        target = Integer.parseInt(stz.nextToken());
        dt[0] = Integer.parseInt(stz.nextToken());
        dt[1] = -Integer.parseInt(stz.nextToken());
        dist = new int[n+1];
    }
}
