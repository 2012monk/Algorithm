package BOJ.N1764듣보잡;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        Set<String> a = new HashSet<>(), b = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            a.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (a.contains(s)) {
                b.add(s);
            }
        }
        System.out.println(b.size());
        System.out.println(String.join("\n", b));
    }
}
