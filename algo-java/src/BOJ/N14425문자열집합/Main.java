package BOJ.N14425문자열집합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n  =Integer.parseInt(stz.nextToken());
        int m  =Integer.parseInt(stz.nextToken());
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            if (set.contains(br.readLine())) result++;
        }
        System.out.println(result);
    }
}
