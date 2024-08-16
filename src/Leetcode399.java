import java.util.*;

public class Leetcode399 {
    // Evaluate Division
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); ++i) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];
            if (!graph.containsKey(a)) {
                graph.put(a, new HashMap<>());
            }
            if (!graph.containsKey(b)) {
                graph.put(b, new HashMap<>());
            }
            graph.get(a).put(b, val);
            graph.get(b).put(a, 1 / val);
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); ++i) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if (!graph.containsKey(a) || !graph.containsKey(b)) {
                ans[i] = -1.0;
                continue;
            }
            Set<String> visited = new HashSet<>();
            double res = dfs(graph, a, b, 1.0, visited);
            ans[i] = res == Double.POSITIVE_INFINITY ? -1.0 : res;
        }

        return ans;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String start, String end, double val, Set<String> visited) {
        if (!graph.containsKey(start)) {
            return Double.POSITIVE_INFINITY;
        }
        if (start.equals(end)) {
            return val;
        }
        visited.add(start);
        for (String next : graph.get(start).keySet()) {
            if (visited.contains(next)) continue;
            double res = dfs(graph, next, end, val * graph.get(start).get(next), visited);
            if (res != Double.POSITIVE_INFINITY) return res;
        }
        return Double.POSITIVE_INFINITY;
    }
}
