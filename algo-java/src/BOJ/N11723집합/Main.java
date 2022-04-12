package BOJ.N11723집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Main {

    static int s = 0;
    static Map<String, Consumer<Integer>> operations = new HashMap<>();
    static Map<String, Runnable> op = new HashMap<>();
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        operations.put("add", Main::add);
        operations.put("remove", Main::remove);
        operations.put("toggle", Main::toggle);
        operations.put("check", Main::check);
        op.put("all", Main::all);
        op.put("empty", Main::empty);

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            if (operations.containsKey(input[0])) {
                operations.get(input[0]).accept(Integer.parseInt(input[1]));
            }
            if (op.containsKey(input[0])) {
                op.get(input[0]).run();
            }
        }
        System.out.println(sb);
    }

    static void add(int x) {
        s |= 1 << x;
    }

    static void remove(int x) {
        s &= ~(1 << x);
    }

    static void toggle(int x) {
        s ^= 1 << x;
    }

    static void all() {
        s = (1 << 21) - 1;
    }

    static void check(int x) {
        if (((1 << x) & s) == 0) {
            sb.append(0).append("\n");
        } else {
            sb.append(1).append("\n");
        }
    }

    static void empty() {
        s = 0;
    }
}
