package BOJ.N3197백조의호수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static int[][] b;
    static boolean[][] v;
    static int n,m,sx=-1, sy, tx, ty, res;
    static int[][] dt = {{0,1},{0,-1},{1,0},{-1,0}};
    static Queue<int[]> waterQ = new ArrayDeque<>();
    static Queue<int[]> moveQ = new ArrayDeque<>(), buf = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        init();
        moveQ.offer(new int[]{sx,sy});
        while (!connected()) {
            melt();
            res++;
        }
        System.out.println(res);
    }

    /**
     * 시작 지점과 끝지점을 BFS로 탐색
     * 진입 하지 못하는 부분은 melt 하기 위한 큐에 저장
     * @return 두 지점이 연결 되어 있을때 true
     */
    static boolean connected() {
        while (!moveQ.isEmpty()) {
            int[] t = moveQ.poll();
            if (t[0] == tx && t[1] == ty) return true;
            for (int[] d : dt) {
                int dx = d[0] + t[0];
                int dy = d[1] + t[1];
                if (dx >= 0 && dx < n && dy >= 0 && dy < m && !v[dx][dy]) {
                    v[dx][dy] = true;
                    if (b[dx][dy] == 1) {
                        buf.offer(new int[]{dx,dy});
                        continue;
                    }
                    moveQ.offer(new int[]{dx,dy});
                }
            }
        }
        moveQ.addAll(buf);
        buf.clear();
        return false;
    }

    /**
     * 이동가능 영역만 담겨있는 큐에서 한칸씩 늘려나간다
     */
    static void melt() {
        int size = waterQ.size();
        while (size-- > 0){
            int[] t = waterQ.poll();
            for (int[] d : dt) {
                int dx = d[0] + t[0];
                int dy = d[1] + t[1];
                if (dx < 0 || dx >= n || dy < 0 || dy >= m) continue;
                if (b[dx][dy] == 1) {
                    b[dx][dy] = 0;
                    waterQ.offer(new int[]{dx,dy});
                }
            }
        }
    }


    static void init() throws IOException {
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        b = new int[n][m];
        v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == 'X') b[i][j] = 1;
                if (s.charAt(j) == '.') waterQ.add(new int[]{i,j});
                if (s.charAt(j) == 'L') {
                    waterQ.add(new int[]{i,j});
                    if (sx == -1){
                        sx = i;sy = j;
                    }
                    else{
                        tx = i;ty = j;
                    }
                }

            }
        }
    }
}
