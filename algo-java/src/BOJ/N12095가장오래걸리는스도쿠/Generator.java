package BOJ.N12095가장오래걸리는스도쿠;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Generator {

    int[][] grid = new int[9][9];
    int[] ver = new int[9];
    int[] hoz = new int[9];
    int[] sq = new int[9];
    private Set<Integer> used = new HashSet<>();
    private Random random = new Random();
    private ArrayDeque<Integer> candidates = new ArrayDeque<>();

    public static void main(String[] args) {
        Generator generator = new Generator();
        Solver solver = new Solver();
        int max = 0;
        int[][] maxGrid = null;
        for (int i = 0; i < 1000; i++) {
            generator.generate();
            int c = solver.solve(generator.grid);
            System.out.println("solver count="+c);
            if (maxGrid == null) {
                maxGrid = generator.grid;
                c = max;
            }
            if (c > max) {
                max = c;
                maxGrid = generator.grid;
            }
        }
        System.out.println(max);
        generator.print(maxGrid);
    }

    public void print(int[][] grid) {
        for (int[] g : grid) {
            for (int i : g) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }
    }

    private void generate() {
        init();
        while (!isValid()) {
            next();
        }
    }

    private void next() {
        int p = candidates.removeFirst();
        int v = random.nextInt(9) + 1;
        if (isValidValue(p, v)) {
            mark(p, v);
            return;
        }
        candidates.addFirst(p);
        next();
    }

    private void init() {
        List<Integer> r = new ArrayList<>();
        grid = new int[9][9];
        ver = new int[9];
        hoz = new int[9];
        sq = new int[9];
        for (int i = 0; i < 81; i++) {
            r.add(i);
        }
        Collections.shuffle(r);
        candidates.clear();
        candidates.addAll(r);
    }

    private void mark(int x, int val) {
        used.add(val);
        grid[x / 9][x % 9] = val;
        int bit = 1 << val;
        ver[x / 9] |= bit;
        hoz[x % 9] |= bit;
        sq[((x / 9) / 3) * 3 + (x % 9) / 3] |= bit;
    }

    private boolean isValidValue(int x, int val) {
        int bit = 1 << val;
        boolean v = (ver[x / 9] & bit) == 0;
        boolean h = (hoz[x % 9] & bit) == 0;
        return v && h && (sq[((x / 9) / 3) * 3 + (x % 9) / 3] & bit) == 0;
    }

    private boolean isValid() {
        if (used.size() < 8) {
            return false;
        }
        return 81 - candidates.size() >= 17;
    }
}
