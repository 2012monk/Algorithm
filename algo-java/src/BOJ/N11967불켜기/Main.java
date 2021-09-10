package BOJ.N11967불켜기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static List<int[]>[][] graph;
    static boolean[][] move,board;
    static int n, m;
    static int[] nx = {0,0,1,-1};
    static int[] ny = {1,-1,0,0};
    static Queue<int[]> q = new ArrayDeque<>();
    static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        init();
        int res = 0;
//        bfs();
        board[0][0] = true;
        dfs(0,0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j]) res++;
            }
        }
        System.out.println(res);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        if (graph[x][y] != null) {
            for (int[] g : graph[x][y]) {
                int dx = g[0];
                int dy = g[1];
                if (isOutside(dx,dy)) continue;
                board[dx][dy] = true;
                if (!move[dx][dy] || visited[dx][dy]) continue;
                dfs(dx,dy);
                move[dx][dy] = false;
                board[dx][dy] = true;
            }
        }

        for (int i = 0; i < 4; i++) {
            int dx = nx[i] + x;
            int dy = ny[i] + y;
            if (!isOutside(dx,dy) && !visited[dx][dy]){
                if (!board[dx][dy]) move[dx][dy] = true;
                else {
                    board[dx][dy] = true;
                    dfs(dx,dy);
                }
            }
        }
    }
    static boolean isOutside(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }

    static int bfs() {
        int res = 0;
        q.offer(new int[]{0,0});
        visited[0][0] = true;
        board[0][0] = true;
        while (!q.isEmpty()){
            int x = q.peek()[0];
            int y = q.poll()[1];
            if (graph[x][y] != null) {
                for (int[] g : graph[x][y]) {
                    if (board[g[0]][g[1]]) continue;
                    board[g[0]][g[1]] = true;
                    res++;
                }
            }
            for (int k = 0; k < 4; k++) {
                int dx = nx[k] + x;
                int dy = ny[k] + y;
                if (dx < 0 || dx >= n || dy < 0 || dy >= n) continue;
                move[dx][dy] = true;
            }
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    if (!board[i][j]||!move[i][j]||visited[i][j]) continue;
//                    visited[i][j] = true;
//                    q.offer(new int[]{i,j});
//                }
//            }
        }
        return res;
    }

    static void init() throws IOException {
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        board = new boolean[n][n];
        graph = new List[n][n];
        move = new boolean[n][n];
        visited = new boolean[n][n];
        for (int k = 0; k < m; k++) {
            stz = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(stz.nextToken())-1;
            int j = Integer.parseInt(stz.nextToken())-1;
            if (graph[i][j] == null) graph[i][j] = new ArrayList<>();
            graph[i][j].add(new int[]{
                Integer.parseInt(stz.nextToken())-1,
                Integer.parseInt(stz.nextToken())-1
            });
        }


    }
}
