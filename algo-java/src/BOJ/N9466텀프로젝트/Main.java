package BOJ.N9466텀프로젝트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static int[] visited;
    static int n, t;
    static int[] graph, dist;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            init();
            int r = 0;
            for (int i = 1; i <= n; i++) {
                if (visited[i] != 0) continue;
                dist[i] = 1;
                r += dfs(i, i);
            }
            sb.append(r).append("\n");
        }
        System.out.println(sb);
    }

    static int dfs(int current, int start) {
        visited[current] = start;
        // 시작한 노드에서 끝난 사이클일때 사이클이 있는 노드의 수를 제외하고 리턴
        if (visited[graph[current]] == start) return dist[graph[current]] - 1;

        if (visited[graph[current]] == 0) {  // 다음 노드에 방문하지 않았을때
            dist[graph[current]] = dist[current] + 1;
            return dfs(graph[current], start);
        }
        return dist[current];  // 다음 노드가 방문되어있지만 현재 노드에서 시작하지 않았을때
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        stz = new StringTokenizer(br.readLine());
        graph = new int[n + 1];
        dist = new int[n + 1];
        visited = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = Integer.parseInt(stz.nextToken());
        }

    }
}
