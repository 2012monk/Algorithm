package BOJ.N1865웜홀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static Node[] nodes;
    static int t, n, m, w;
    static long INF = 2000000000;
    static long[] dist;
    static class Node {
        int next,weight;
        ArrayList<Node> edges = new ArrayList<>();
        public Node(int next, int weight) {this.next = next;this.weight = weight;}
    }

    public static boolean bellmanFord(){
        dist[1] = 0;
        for (int k = 0; k < n; k++) {
            for (int i = 1; i <= n; i++) {
                if (dist[i] == INF) continue;
                for (Node edge : nodes[i].edges) {
                    if (dist[edge.next] > dist[i] + edge.weight) {
                        dist[edge.next] = dist[i] + edge.weight;
                        if (k == n - 1) return true;
                    }
                }
            }
        }
        // Result => N번째에도 최단거리가 갱신이 되었는가? 음수사이클이 있는가
        return false;
    }

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            stz = new StringTokenizer(br.readLine());
            n = Integer.parseInt(stz.nextToken());
            m = Integer.parseInt(stz.nextToken());
            w = Integer.parseInt(stz.nextToken());
            nodes = new Node[n+1];
            dist = new long[n+1];
            Arrays.fill(dist, INF);
            for (int i = 1; i <= n; i++) {
                nodes[i] = new Node(i, 0);
            }
            for (int i = 0; i < m+w; i++) {
                stz = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(stz.nextToken());
                int v = Integer.parseInt(stz.nextToken());
                int w = Integer.parseInt(stz.nextToken());
                if (i < m){
                    nodes[u].edges.add(new Node(v, w));
                    nodes[v].edges.add(new Node(u, w));
                }
                else{
                    nodes[u].edges.add(new Node(v, -w));
                }
            }

            if (bellmanFord()) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }


}
