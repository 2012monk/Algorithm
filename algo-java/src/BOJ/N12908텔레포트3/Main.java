package BOJ.N12908텔레포트3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static P[] ps = new P[8];
    static int[][] dist = new int[8][8];
    static int start = 0, end = 7;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        P s = new P(Integer.parseInt(stz.nextToken()), Integer.parseInt(stz.nextToken()));
        stz = new StringTokenizer(br.readLine());
        P e = new P(Integer.parseInt(stz.nextToken()), Integer.parseInt(stz.nextToken()));
        ps[start] = s;
        ps[end] = e;
        for (int i = 0; i < 8; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        dist[start][end] = dist[end][start] = Math.abs(e.x - s.x) + Math.abs(e.y - s.y);
        for (int i = 1; i <= 5; i+=2) {
            stz = new StringTokenizer(br.readLine());
            s = new P(Integer.parseInt(stz.nextToken()), Integer.parseInt(stz.nextToken()));
            e = new P(Integer.parseInt(stz.nextToken()), Integer.parseInt(stz.nextToken()));
            ps[i] = s;
            ps[i + 1] = e;
            dist[i][i + 1] = dist[i + 1][i] = Math.min(Math.abs(e.x - s.x) + Math.abs(e.y - s.y), 10);
        }

        for (int i = 0; i <= end; i++) {
            for (int j = 0; j <= end; j++) {
                s = ps[i];
                e = ps[j];
                dist[i][j] = Math.min(dist[i][j], Math.abs(e.x - s.x) + Math.abs(e.y - s.y));
            }
        }
        System.out.println(shortestPath());
    }

    static long shortestPath() {
        PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingLong(v -> -v[1]));
        long[] d = new long[8];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;
        q.add(new long[]{start, 0});
        while (!q.isEmpty()) {
            long[] p = q.poll();
            if (d[(int) p[0]] < p[1]) continue;

            for (int i = 0; i < 8; i++) {
                if (i == p[0]) continue;
                long w = dist[(int) p[0]][i] + p[1];
                if (w < d[i]) {
                    d[i] = w;
                    q.add(new long[]{i, w});
                }
            }
        }
        return d[end];
    }

    static class P {
        int x, y;
        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
