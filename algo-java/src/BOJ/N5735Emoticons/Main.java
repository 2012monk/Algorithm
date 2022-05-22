package BOJ.N5735Emoticons;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int words = 126 - 32;
    static Trie root;

    static class Trie {
        Trie[] children = new Trie[words];
        Trie fail;
        boolean word;

        void add(int i, String s) {
            if (i == s.length()) {
                word = true;
                return;
            }
            int next = s.charAt(i) - ' ';
            if (children[next] == null) children[next] = new Trie();
            children[next].add(i + 1, s);
        }

        int count(String s) {
            Trie cur = this;
            StringBuilder sb = new StringBuilder(s);
            int ret = 0;
            for (int i = 0; i < sb.length(); i++) {
                int next = sb.charAt(i) - ' ';
                while (cur != this && cur.children[next] == null) {
                    cur = cur.fail;
                }
                if (cur.children[next] != null) {
                    cur = cur.children[next];
                }
                if (cur.word) {
                    ret++;
                    sb.replace(i, i + 1, " ");
                    i--;
                }
            }
            return ret;
        }
    }

    static void failure() {
        Queue<Trie> q = new ArrayDeque<>();
        q.add(root);
        root.fail = root;
        while (!q.isEmpty()) {
            Trie cur = q.poll();
            failNode(cur, q);
        }
    }

    static void failNode(Trie cur, Queue<Trie> q) {
        if (cur == null) return ;
        for (int i = 0; i < words; i++) {
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
                next.word = next.word || next.fail.word;
            }
            q.add(next);
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        StringBuilder sb = new StringBuilder();
        while (true) {
            root = new Trie();
            stz = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stz.nextToken());
            int m = Integer.parseInt(stz.nextToken());
            if( n == 0) break;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                root.add(0, br.readLine());
            }
            failure();
            for (int i = 0; i < m; i++) {
                ans += root.count(br.readLine());
            }
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }
}
