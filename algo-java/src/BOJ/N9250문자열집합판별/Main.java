package BOJ.N9250문자열집합판별;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static Trie root = new Trie();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            add(br.readLine());
        }
        failure(root);
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            if (query(br.readLine())) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void failure(Trie root) {
        Queue<Trie> q = new ArrayDeque<>();
        q.add(root);
        root.fail = root;

        while (!q.isEmpty()) {
            Trie cur = q.poll();
            if (cur == null) continue;

            for (int i = 0; i < 26; i++) {
                Trie next = cur.children[i];
                if (next == null) continue;
                if (cur == root) {
                    next.fail = root;
                } else {
                    Trie f = cur.fail;
                    while (f != root && f.children[i] == null) {
                        f = f.fail;
                    }
                    if (f.children[i] != null) {
                        f = f.children[i];
                    }
                    next.fail = f;
                }
                if (next.fail.word) {
                    next.word = true;
                }
                q.add(next);
            }
        }
    }

    static boolean query(String s) {
        Trie cur = root;
        for (int i = 0; i < s.length(); i++) {
            int next = s.charAt(i) - 'a';
            while (cur != root && cur.children[next] == null) {
                cur = cur.fail;
            }
            if (cur.children[next] != null) {
                cur = cur.children[next];
            }
            if (cur.word) return true;
        }
        return false;
    }

    static void add(String s) {
        Trie node = root;
        for (int i = 0; i < s.length(); i++) {
            int next = s.charAt(i) - 'a';
            if (node.children[next] ==null) {
                node.children[next] = new Trie();
            }
            node = node.children[next];
        }
        node.word = true;
    }

    static class Trie {
        Trie[] children = new Trie[26];
        Trie fail;
        boolean word;
    }
}
