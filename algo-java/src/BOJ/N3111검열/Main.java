package BOJ.N3111검열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    static String target;
    static LinkedList<Character>
        l = new LinkedList<>(),
        r = new LinkedList<>(),
        a = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = br.readLine();
        for (char c : br.readLine().toCharArray()) {
            a.add(c);
        }
        solve();
    }

    static void solve() {
        while (true) {
            if (!matchFirst()) break;
            if (!matchLast()) break;
        }
        StringBuilder sb = new StringBuilder();
        while (!l.isEmpty()) sb.append(l.removeFirst());
        while (!r.isEmpty()) sb.append(r.removeFirst());
        while (true) {
            int i = sb.indexOf(target);
            if (i < 0) break;
            sb.delete(i, i + target.length());
        }
        System.out.println(sb);
    }

    static boolean matchFirst() {
        while (!a.isEmpty() && !match(l.size() - target.length(), l)) {
            l.addLast(a.removeFirst());
        }
        boolean r = match(l.size() - target.length(), l);
        if (r) {
            for (int i = 0; i < target.length(); i++) {
                l.removeLast();
            }
        }
        return r;
    }

    static boolean matchLast() {
        while (!a.isEmpty() && !match(0, r)) {
            r.addFirst(a.removeLast());
        }
        boolean ret = match(0, r);
        if (ret) {
            for (int i = 0; i < target.length(); i++) {
                r.removeFirst();
            }
        }
        return ret;
    }

    private static boolean match(int j, LinkedList<Character> q) {
        if (q.size() < target.length()) return false;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) != q.get(j + i)) return false;
        }
        return true;
    }
}
