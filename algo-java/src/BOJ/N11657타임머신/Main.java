package BOJ.N11657타임머신;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static long[] dist;
    static Node[] nodes;
    static int n, INF = (int) 10e18;

    public static void bellmenFord() {
        boolean flag = false;
        for (int k = 0; k < n; k++) {
            for (int i = 1; i <= n; i++) {
                if (dist[i] == INF) continue;
                for (Node edge : nodes[i].edges) {
                    if (dist[edge.n] > dist[i] + edge.w) {
                        dist[edge.n] = dist[i] + edge.w;
                        flag = k == n - 1;
                    }
                }
            }
        }
        // verify
        if (flag) {
            System.out.println(-1);
            return;
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(dist[i]==INF?-1:dist[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        int t = Integer.parseInt(stz.nextToken());

        dist = new long[n+1];
        nodes = new Node[n+1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i, 0);
        }
        for (int i = 0; i < t; i++) {
            stz = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stz.nextToken());
            int v = Integer.parseInt(stz.nextToken());
            int w = Integer.parseInt(stz.nextToken());
            nodes[u].edges.add(new Node(v, w));
        }
        bellmenFord();
    }
    static class Node {
        int n,w;
        ArrayList<Node> edges = new ArrayList<>();
        public Node(int n, int w) {this.n = n;this.w = w;}
    }


}
