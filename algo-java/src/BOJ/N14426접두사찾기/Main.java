package BOJ.N14426접두사찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Trie set = new Trie('\0');

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());

        for (int i = 0; i < n; i++) {
            set.add(0, br.readLine());
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            if (set.contains(0, br.readLine())) result++;
        }
        System.out.println(result);
    }

    static class Trie {
        Trie[] children = new Trie[26];
        char v;

        public Trie(char v) {
            this.v = v;
        }

        void add(int idx, String s) {
            if (idx == s.length()) return;
            int next = s.charAt(idx) - 'a';
            if (children[next] == null) children[next] = new Trie(s.charAt(idx));
            children[next].add(idx + 1, s);
        }

        boolean contains(int idx, String s) {
            if (idx == s.length()) return true;
            if(children[s.charAt(idx) - 'a'] == null) return false;
            return children[s.charAt(idx) - 'a'].contains(idx + 1, s);
        }
    }
}
