package BOJ.N16118달빛여우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static List<Edge>[] graph;

    static int MAX = 2000000000;
    static int[][] distWolf = new int[4001][2];
    static int[] distFox = new int[4001];
    static int V,E;

    public static void main(String[] args) throws IOException {
        init();
        wolf();
        fox();
        int res = 0;
        for (int i = 1; i <= V; i++) {
            if (distFox[i] < Math.min(distWolf[i][0], distWolf[i][1])) res++;
        }
        System.out.println(res);
    }

    static void wolf() {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.offer(new Edge(1,0,0));
        distWolf[1][0] = 0;
        while (!q.isEmpty()) {
            Edge e = q.poll();
            if (distWolf[e.v][e.to] < e.w) continue;
            int nextState = e.to^1;
            for (Edge next: graph[e.v]) {
                int cost = e.w + (e.to == 0 ? next.w / 2 : next.w * 2);

                if (distWolf[next.v][nextState] > cost) {
                    distWolf[next.v][nextState] = cost;
                    q.offer(new Edge(next.v, nextState, cost));
                }
            }
        }
    }

    static void fox() {
        PriorityQueue<Edge> q = new PriorityQueue<>();

        distFox[1] = 0;
        q.offer(new Edge(1,0,0));
        while (!q.isEmpty()) {
            Edge e = q.poll();
            if (distFox[e.v] < e.w) continue;

            for (Edge next : graph[e.v]) {
                int cost = next.w + e.w;
                if (distFox[next.v] > cost) {
                    distFox[next.v] = cost;
                    q.offer(new Edge(next.v,0,cost));
                }
            }
        }
    }

    static void init() throws IOException {
        stz = new StringTokenizer(br.readLine());
        V = Integer.parseInt(stz.nextToken());
        E = Integer.parseInt(stz.nextToken());
        graph = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            distFox[i] = MAX;
            Arrays.fill(distWolf[i], MAX);
        }
        for (int i = 0; i < E; i++) {
            stz = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stz.nextToken());
            int v = Integer.parseInt(stz.nextToken());
            int w = Integer.parseInt(stz.nextToken());
            graph[u].add(new Edge(v,0,w*2));
            graph[v].add(new Edge(u,0,w*2));
        }
    }

    static class Edge implements Comparable<Edge>{
        int v,to,w;

        public Edge(int v, int to, int w) {
            this.v = v;this.to = to;this.w = w;
        }

        @Override
        public int compareTo(Edge edge) {
            return w-edge.w;
        }
    }
}
