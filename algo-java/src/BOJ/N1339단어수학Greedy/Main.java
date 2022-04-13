package BOJ.N1339단어수학Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    static Integer[] map = new Integer[27];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Arrays.fill(map, 0);
        String[] inputs = new String[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = br.readLine();
        }
        for (String s : inputs) {
            int l = s.length() - 1;
            for (char c : s.toCharArray()) {
                map[c - 'A'] += (int) Math.pow(10, l--);
            }
        }
        int total = 0, number = 9;
        Arrays.sort(map, Comparator.comparingInt(v -> -v));
        for (Integer i : map) {
            if (i==0) break;
            total += i * number--;
        }
        System.out.println(total);
    }
}
