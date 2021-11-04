package BOJ.N2261가장가까운두점;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static int n;
    static Map<Integer, List<Integer>> coordinates = new HashMap<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stz.nextToken());
            int y = Integer.parseInt(stz.nextToken());

            coordinates.put(x, coordinates.getOrDefault(
                x, new ArrayList<>()
            ));
            coordinates.get(x).add(y);
        }
        coordinates.forEach((k, v) -> Collections.sort(v));
    }


}
