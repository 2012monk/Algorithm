package BOJ.N4574스도노미쿠;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    static int[][] d = {
        {1, 0}, {0, 1}, {0, 1}, {0, -1}
    };
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int count = 1;
    List<Integer> candidates = new ArrayList<>();
    boolean[][] v, check;
    int[][] grid = new int[9][9];
    int[] hoz, vet, sq;

    public static void main(String[] args) throws IOException {
        int n;
        Main m = new Main();
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            m.solve(n);
        }
        bw.flush();
    }

    void solve(int n) throws IOException {
        StringTokenizer stz;
        init();
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            int v1 = 0, v2 = 0;
            for (int j = 0; j < 2; j++) {
                int val = Integer.parseInt(stz.nextToken());
                String c = stz.nextToken();
                int x = c.charAt(0) - 'A';
                int y = c.charAt(1) - '0' - 1;
                mark(x,y,val);
                check[x][y] = true;
                if (v1 == 0) {
                    v1 = val;
                } else {
                    v2 = val;
                }
            }
            v[v1][v2] = v[v2][v1] = true;
        }
        stz = new StringTokenizer(br.readLine());
        for (int i = 1; i < 10; i++) {
            String c = stz.nextToken();
            int x = c.charAt(0) - 'A';
            int y = c.charAt(1) - '0' - 1;
            mark(x, y, i);
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    candidates.add(i * 9 + j);
                }
            }
        }
        if (find(0)) {
            print();
        }
    }

    private void print() {
        try {
            bw.write("Puzzle " + count++);
            bw.newLine();
            for (int[] g : grid) {
                bw.write(Arrays.stream(g).mapToObj(String::valueOf).collect(Collectors.joining()));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    boolean find(int p) {
        if (p == candidates.size()) {
            return true;
        }
        int x = candidates.get(p) / 9, y = candidates.get(p) % 9;
        if (grid[x][y] != 0) {
            return find(p + 1);
        }
        for (int k = 0; k < 2; k++) {
            int dx = x + d[k][0];
            int dy = y + d[k][1];
            if (dx < 0 || dy < 0 || dx >= 9 || dy >= 9)  continue;
            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    if (i == j)  continue;
                    if (isValid(x, y, dx, dy, i, j)) {
                        mark(x, y, dx, dy, i, j);
                        if (find(p + 1)) {
                            return true;
                        }
                        unMark(x, y, dx, dy, i, j);
                    }
                }
            }
        }
        return false;
    }

    boolean isValid(int x, int y, int dx, int dy, int i, int j) {
        return isValid(x, y, i) && isValid(dx, dy, j) && !v[i][j];
    }

    void mark(int x, int y, int dx, int dy, int i, int j) {
        mark(x, y, i);
        mark(dx, dy, j);
        v[i][j] = v[j][i] = true;
    }

    void unMark(int x, int y, int dx, int dy, int i, int j) {
        unMark(x, y, i);
        unMark(dx, dy, j);
        v[i][j] = v[j][i] = false;
    }

    void mark(int x, int y, int val) {
        grid[x][y] = val;
        vet[x] |= 1 << val;
        hoz[y] |= 1 << val;
        sq[(x / 3) * 3 + y / 3] |= 1 << val;
    }

    void unMark(int x, int y, int val) {
        grid[x][y] = 0;
        vet[x] &= ~(1 << val);
        hoz[y] &= ~(1 << val);
        sq[(x / 3) * 3 + y / 3] &= ~(1 << val);
    }
    boolean isValid(int x, int y, int val) {
        boolean v = (vet[x] & (1 << val)) == 0;
        boolean h = (hoz[y] & (1 << val)) == 0;
        boolean sqx = (sq[(x / 3) * 3 + y / 3] & (1 << val)) == 0;
        return v && h && sqx && grid[x][y] == 0;
    }

    void init() {
        v = new boolean[10][10];
        check = new boolean[9][9];
        grid = new int[9][9];
        hoz = new int[9];
        vet = new int[9];
        sq = new int[9];
        candidates.clear();
    }
}
