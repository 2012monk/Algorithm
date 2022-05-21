package BOJ.N10256돌연변이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int[] map = new int[26];
    static Trie trie;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        map['C' - 'A'] = 1;
        map['T' - 'A'] = 2;
        map['G' - 'A'] = 3;
        while (t-- > 0) {
            br.readLine();
            trie = new Trie();

            String dna = br.readLine();
            add(br.readLine());
            System.out.println(trie.query(dna));
        }
    }

    static void add(String marker) {
        trie.add(marker);
        for (int i = 0; i < marker.length() - 1; i++) {
            for (int j = i + 1; j < marker.length(); j++) {
                StringBuilder sb = new StringBuilder(marker);
                String r = new StringBuilder(marker.substring(i, j + 1)).reverse().toString();
                trie.add(sb.replace(i, j + 1, r).toString());
            }
        }
        trie.failure();
    }

    static class Trie {
        Node root = new Node();

        void add(String s) {
            root.add(s, 0);
        }

        int query(String s) {
            Node cur = root;
            int ret = 0;
            for (int i = 0; i < s.length(); i++) {
                int next = map[s.charAt(i) - 'A'];

                while (cur != root && cur.children[next] == null) {
                    cur = cur.fail;
                }
                if (cur.children[next] != null) {
                    cur = cur.children[next];
                }
                if (cur.match) ret++;
            }
            return ret;
        }

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

            for (int i = 0; i < 4; i++) {
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
                }

                if (next.fail.match) {
                    next.match = true;
                }
                q.add(next);
            }
        }
    }

    static class Node {
        Node[] children = new Node[4];
        Node fail;
        boolean match;
        void add(String s, int i) {
            if (i == s.length()) {
                match = true;
                return;
            }
            int next = map[s.charAt(i) - 'A'];
            if (children[next] == null) children[next] = new Node();
            children[next].add(s, i + 1);
        }
    }
}
