package BOJ.N12095가장오래걸리는스도쿠;

import java.util.ArrayList;
import java.util.List;

public class Solver {

    static int LIMIT = 10000000;

    private final List<Integer> candidates = new ArrayList<>();
    private int[][] grid = new int[9][9];
    private int[] ver = new int[9], hoz = new int[9], square = new int[9];
    private int count;

    private void copy(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            System.arraycopy(grid[i], 0, this.grid[i], 0, 9);
        }
    }

    public int solve(int[][] grid) {
        copy(grid);
        init();
        if (!find(0)) {
            return -1;
        }
        if (count >= LIMIT) {
            return 0;
        }
        return count;
    }

    private void init() {
        ver = new int[9];
        hoz = new int[9];
        square = new int[9];
        count = 0;
        candidates.clear();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] != 0) {
                    mark(i, j, grid[i][j]);
                } else {
                    candidates.add(i * 9 + j);
                }
            }
        }
    }

    private boolean find(int p) {
        count++;
        if (count >= LIMIT) {
            return true;
        }
        if (p == candidates.size()) {
            return true;
        }
        int x = candidates.get(p) / 9, y = candidates.get(p) % 9;
        for (int i = 1; i <= 9; i++) {
            if (!isValid(x, y, i)) {
                continue;
            }
            mark(x, y, i);
            if (find(p + 1)) {
                return true;
            }
            unMark(x, y, i);
        }
        return false;
    }

    void mark(int x, int y, int val) {
        grid[x][y] = val;
        ver[x] |= 1 << val;
        hoz[y] |= 1 << val;
        square[(x / 3) * 3 + y / 3] |= 1 << val;
    }

    void unMark(int x, int y, int val) {
        grid[x][y] = 0;
        ver[x] &= ~(1 << val);
        hoz[y] &= ~(1 << val);
        square[(x / 3) * 3 + y / 3] &= ~(1 << val);

    }

    boolean isValid(int x, int y, int val) {
        boolean v = (ver[x] & (1 << val)) == 0;
        boolean h = (hoz[y] & (1 << val)) == 0;
        boolean sq = (square[(x / 3) * 3 + y / 3] & (1 << val)) == 0;
        return v && h && sq;
    }
}

