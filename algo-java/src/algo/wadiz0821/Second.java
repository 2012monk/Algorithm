package algo.wadiz0821;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Second {

    public String[] div(String t) {
        int i = t.lastIndexOf('.');
        return new String[]{t.substring(0, i), t.substring(i)};
    }

    public String[] solution(String[] code) {
        Deque<Pair<Integer, String>> st = new ArrayDeque<>();
        List<String> res = new ArrayList<>();
        for (String c: code) {

            if (c.contains("print")) {
                List<Pair<Integer, String >> tmp = new ArrayList<>();

                String v = c.split(" ")[1];
                int level = c.lastIndexOf('.');

                free(st, level);
                boolean isEmpty = true;
                while (!st.isEmpty()) {
                    Pair<Integer, String> p = st.removeLast();
                    tmp.add(p);
                    if (p.sc.contains(v)) {
                        res.add(p.sc);
                        isEmpty = false;
                        break;
                    }
                }
                if (isEmpty) res.add("error");

                st.addAll(tmp);

            }
            else {
                int level = c.lastIndexOf('.');
                String var = c.substring(level+1);

                free(st,level);
                st.add(new Pair<>(level, var));
            }
        }
        return res.toArray(new String[0]);
    }

    private void free(Deque<Pair<Integer, String>> st, int level) {
        while (!st.isEmpty() && st.peekLast().ft > level)
            st.removeLast();
    }

    static class Pair<T, E>{
        T ft;
        E sc;
        public Pair(T t, E e){
            this.ft = t;
            this.sc = e;
        }

    }

    public static void main(String[] args) {
        String raw = "a=3,"
            + "..a=4,"
            + "..b=3,"
            + "print a," // a=3
            + "....c=6,"
            + "....print a," // a=3
            + "....print c," // c=6
            + "...b=6,"
            + "...print b," //b=6
            + "...print c," // error
            + ".....a=6,"
            + ".....b=7,"
            + ".....print b," // b=7
            + "..print a," //a=4
            + "print a," //a=4
            + "print b," //b=3
            + "b=10,"
            + "print b"; // b=10
        String[] code = raw.split(",");
        for (String s: new Second().solution(code)) {
            System.out.println(s);
        }
    }

}
