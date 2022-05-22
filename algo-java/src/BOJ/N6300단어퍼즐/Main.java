package BOJ.N6300단어퍼즐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Trie trie = new Trie();
    static int n,m,k;
    static char[][] words;
    static int[] queries;
    static int[][] ans;
    static int[][] d = { {-1 ,0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    static char[] w = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        words = new char[n][m];
        ans = new int[k][3];
        queries = new int[k];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < k; i++) {
            String s = br.readLine();
            queries[i] = s.length();
            trie.root.add(0, s, i);
            ans[i] = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        }
        trie.failure();
        solve();
        bw.flush();
    }

    static void solve() throws Exception {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i != 0 && i != n - 1 && j != 0 && j != m - 1) continue;
                for (int k = 0; k < d.length; k++) {
                    trie.query(i, j, k);
                }
            }
        }
        for (int[] an : ans) {
            bw.write(String.format("%d %d %c\n", an[0], an[1], w[an[2]]));
        }
    }

    static class Trie {
        Node root = new Node();

        void failure() {
            Queue<Node> q = new ArrayDeque<>();
            q.add(root);
            root.fail = root;
            while (!q.isEmpty()) {
                Node cur = q.poll();
                failNode(cur, q);
            }
        }

        void failNode(Node cur, Queue<Node> q) {
            if (cur == null) return ;
            for (int i = 0; i < 26; i++) {
                Node next = cur.children[i];
                if (next == null) continue;
                if (cur == root) {
                    next.fail = root;
                } else {
                    Node f = cur.fail;
                    while (f != root && f.children[i] == null) {
                        f = f.fail;
                    }
                    if (f.children[i] != null) {
                        f = f.children[i];
                    }
                    next.fail = f;
                    if (next.fail.a != null) {
                        if (next.a == null) {
                            next.a = new ArrayList<>();
                        }
                        next.a.addAll(next.fail.a);
                    }
                }
                q.add(next);
            }
        }

        void query(int x, int y, int dir) {
            Node cur = root;
            while (0 <= x && x < n && 0 <= y && y < m) {
                int next = words[x][y] - 'A';

                while (cur != root && cur.children[next] == null) {
                    cur = cur.fail;
                }
                if (cur.children[next] != null) {
                    cur = cur.children[next];
                }
                if (cur.a != null) {
                    for (Integer k : cur.a) {
                        int px = x - d[dir][0] * (queries[k]- 1);
                        int py = y - d[dir][1] * (queries[k]- 1);
                        int[] a = new int[]{px,py,dir};
                        if (smaller(a, ans[k])) {
                            ans[k] = a;
                        }
                    }
                }
                x += d[dir][0];
                y += d[dir][1];
            }
        }
    }

    static boolean smaller(int[] a, int[] b) {
        if (a[0] > b[0]) return false;
        if (a[1] > b[1]) return false;
        return a[2] < b[2];
    }

    static class Node {
        Node[] children = new Node[26];
        Node fail;
        List<Integer> a;

        void add(int i, String s, int k) {
            if (i == s.length()) {
                if (a == null) {
                    a = new ArrayList<>();
                }
                a.add(k);
                return;
            }
            int next = s.charAt(i) - 'A';
            if (children[next] == null) children[next] = new Node();
            children[next].add(i + 1, s, k);
        }
    }
}
