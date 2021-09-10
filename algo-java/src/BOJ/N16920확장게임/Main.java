package BOJ.N16920확장게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static int n, m, p;
    static int[][] board;
    static int[] step;
    static PriorityQueue<Dot> q = new PriorityQueue<>();
    static int[] nx = new int[]{0,0,1,-1};
    static int[] ny = new int[]{1,-1,0,0,};

    public static void main(String[] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        p = Integer.parseInt(stz.nextToken());
        stz = new StringTokenizer(br.readLine());
        step = new int[p+1];
        board = new int[n][m];
        for (int i = 1; i <= p; i++) {
            step[i] = Integer.parseInt(stz.nextToken());
        }
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == '#'){
                    board[i][j] = -1;
                }
                else if (s.charAt(j) != '.') {
                    board[i][j] = Integer.parseInt(s.substring(j,j+1));
                    q.offer(new Dot(i,j,0,board[i][j]));
                }
            }
        }
        bfs();
        for (int i = 1; i <= p; i++) {
            step[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == -1) continue;
                step[board[i][j]]++;
            }
        }
        for (int i = 1; i <= p; i++) {
            System.out.printf("%d ", step[i]);
        }
        System.out.println();
    }

    static void bfs() {

        while (!q.isEmpty()) {
            Dot d = q.poll();
            int currentOrder = d.order%10;
            int nextOrder = d.cnt % step[currentOrder] == step[currentOrder]-1 ? d.order + 10 : d.order;
            // 턴을 다 소모했으면 우선순위를 뒤로 미룬다
            for (int i = 0; i < 4; i++) {
                int dx = nx[i] + d.x;
                int dy = ny[i] + d.y;
                if (dx < 0 || dx >= n || dy < 0 || dy >= m) continue;
                if (board[dx][dy] != 0) continue;
                board[dx][dy] = currentOrder;
                q.offer(new Dot(dx,dy,d.cnt+1,nextOrder));
            }
        }
        print();
    }

    static class Dot implements Comparable<Dot>{
        int x,y, cnt, order;

        public Dot(int x, int y, int c, int p) {
            this.x = x;this.y = y;this.cnt = c;this.order = p;
        }
        @Override
        public int compareTo(Dot dot) {
            return order == dot.order ? cnt-dot.cnt : order-dot.order;  // 같은 order 이더라도 순서에 따라 갈수있게
        }
    }

    static void print() {
        for (int[] bb : board) {
            for (int i : bb) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }
        System.out.println();
    }

}
