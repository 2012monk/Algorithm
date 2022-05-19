package BOJ.N12906새로운하노이탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {

    static Tower ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = new String[3];
        for (int i = 0; i < 3; i++) {
            String[] s = br.readLine().split(" ");
            if (s.length == 1) {
                input[i] = "";
            } else {
                input[i] = s[1];
            }
        }
        Tower t = new Tower(0, input);
        int a = count(t, 'A');
        int b = count(t, 'B');
        int c = count(t, 'C');
        ans = new Tower(0, "A".repeat(a),
            "B".repeat(b), "C".repeat(c));
        System.out.println(bfs(t));
    }

    static void print(Tower t) {
        System.out.println(Arrays.toString(t.towers));
    }

    static int bfs(Tower start) {
        Queue<Tower> q = new LinkedList<>();
        Set<Tower> v = new HashSet<>();
        q.add(start);
        v.add(start);
        while (!q.isEmpty()) {
            Tower t = q.poll();
//            print(t);

            if (t.equals(ans)) {
                return t.d;
            }

            for (int i = 0; i < 3; i++) {
                if (t.towers[i].isEmpty()) continue;
                String s = String.valueOf(t.towers[i].charAt(t.towers[i].length() - 1));
                for (int j = 0; j < 3; j++) {
                    if (i == j) continue;
                    int next = 3 - i - j;
                    String[] a = Arrays.copyOf(t.towers, 3);
                    a[i] = a[i].substring(0, a[i].length() - 1);
                    a[next] = a[next] + s;
                    Tower nt = new Tower(t.d + 1, a);
                    if (v.contains(nt)) continue;
                    v.add(nt);
                    q.add(nt);
                }
            }
        }
        return 0;
    }

    static int count(Tower t, char a) {
        int c = 0;
        for (String s : t.towers) {
            c += s.chars().filter(k -> k == a).count();
        }
        return c;
    }

    static class Tower {
        String[] towers;
        int d;

        public Tower(int d, String ...towers) {
            this.towers = towers;
            this.d = d;
        }

        @Override
        public boolean equals(Object o) {
            Tower tower = (Tower) o;
            return Arrays.equals(towers, tower.towers);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(towers);
        }
    }
}
