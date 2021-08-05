package algo.leetcode.ReconstructItineary332;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    private final LinkedList<String> results = new LinkedList<>();

    private final Map<String, PriorityQueue<String>> graph = new HashMap<>();

    public void dfs(String key) {
        while (graph.containsKey(key) &&
            !graph.get(key).isEmpty()) {
            dfs(graph.get(key).poll());
        }
        results.addFirst(key);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }

        dfs("JFK");
        return results;
    }

}
