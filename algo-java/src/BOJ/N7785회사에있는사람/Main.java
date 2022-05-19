package BOJ.N7785회사에있는사람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static TreeSet<String> company = new TreeSet<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            String name = stz.nextToken();
            String log = stz.nextToken();

            if (log.equals("enter")) {
                company.add(name);
            }
            if (log.equals("leave")) {
                company.remove(name);
            }
        }
        System.out.println(String.join("\n", company));
    }
}
