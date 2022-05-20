package BOJ.N1786찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static char[] haystack, pattern;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        haystack = br.readLine().toCharArray();
        pattern = br.readLine().toCharArray();
        List<Integer> result = count();
        String sb = String.valueOf(result.size()) + '\n'
            + result.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.print(sb);
    }

    static List<Integer> count() {
        List<Integer> r = new ArrayList<>();
        int[] table = getTable();
        int matched = 0, head = 0, size = haystack.length - pattern.length;
        while (head <= size) {
            if (matched < pattern.length && haystack[head + matched] == pattern[matched]) {
                matched++;
                if (matched == pattern.length) {
                    r.add(head + 1);
                }
                continue;
            }
            if (matched != 0) {
                head += matched - table[matched - 1];
                matched = table[matched - 1];
                continue;
            }
            head++;
        }
        return r;
    }

    private static int[] getTable() {
        int[] tb = new int[pattern.length];
        int head = 1, matched = 0;
        while (head + matched < tb.length) {
            if (pattern[head + matched] == pattern[matched]) {
                matched++;
                tb[head + matched - 1] = matched;
                continue;
            }
            if (matched != 0) {
                head += matched - tb[matched - 1];
                matched = tb[matched - 1];
                continue;
            }
            head++;
        }
        return tb;
    }
}
