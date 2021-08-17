package algo.backjoon.Stack10828;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void regex() {

        String cmd = "push 1";
        Matcher matcher = Pattern.compile("push").matcher(cmd);
        assert matcher.find();
        System.out.println("matcher.group() = " + matcher.group());
    }

    @Test
    void main() throws IOException {
        String in = "14\n" +
            "push 1\n" +
            "push 2\n" +
            "top\n" +
            "size\n" +
            "empty\n" +
            "pop\n" +
            "pop\n" +
            "pop\n" +
            "size\n" +
            "empty\n" +
            "pop\n" +
            "push 3\n" +
            "empty\n" +
            "top";

        Main.test(in);
        System.out.println(in);

    }

    @Test
    void main2() throws IOException {

        System.out.println("push 1");
        System.out.println("size ; " + Main.size());
        System.out.println(Main.empty());
        Main.push(1);
        System.out.println(Main.top());
        Main.push(2);
        System.out.println(Main.pop());
        System.out.println(Main.pop());
    }
}