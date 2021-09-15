package BOJ.N1738골목길;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    final static int INF = Integer.MIN_VALUE;
    static Node[] nodes;
    static long[] dist;
    static int n,m;

    static class Node{
        int v, weight,prev;
        ArrayList<Node> edges = new ArrayList<>();
        public Node(int n, int weight) {this.v = n;this.weight = weight;}
    }

    static void bellmanFord(){
        dist[n] = 0;
        boolean updated = false;
        for (int k = 0; k < n; k++) {
            updated = false;
            for (int i = 1; i <= n; i++) {
                if (dist[i] == INF) continue;
                for (Node edge : nodes[i].edges) {
                    if (dist[edge.v] < dist[i] + edge.weight) {
                        updated = true;
                        dist[edge.v] = dist[i] + edge.weight;
                        nodes[edge.v].prev = i;
                    }
                }
            }
            if (!updated) break;
        }
        if (updated || dist[1] == INF) {
            System.out.println(-1);
            return ;
        }

        StringBuilder sb = new StringBuilder();
        int cur = 1;
        while (cur != n){
            sb.append(cur).append(" ");
            cur = nodes[cur].prev;
        }
        sb.append(n);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        dist = new long[n+1];
        nodes = new Node[n+1];
        Arrays.fill(dist, INF);
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i, 0);
        }

        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stz.nextToken());
            int v = Integer.parseInt(stz.nextToken());
            int w = Integer.parseInt(stz.nextToken());
//            nodes[u].edges.add(new Node(v, w));
            nodes[v].edges.add(new Node(u, w));
        }


        bellmanFord();


    }


}
