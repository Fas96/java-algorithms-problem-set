package leetcode.Y2023.personal.shortestpath;

import java.util.*;

public class Q399EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Map<String,Double>> mapValuePairs= new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String x=equations.get(i).get(0);
            String y=equations.get(i).get(1);
            mapValuePairs.putIfAbsent(x, new HashMap<>());
            mapValuePairs.get(x).put(x,values[i]);

            mapValuePairs.putIfAbsent(y, new HashMap<>());
            mapValuePairs.get(x).put(y,1/values[i]);
        }
        int QN=queries.size();
        double[] answer= new double[QN];
        for (int i = 0; i < QN; i++) {
            answer[i]=dfs(queries.get(i).get(0) , queries.get(i).get(1) , new HashSet<>(), mapValuePairs);

        }
        return  answer;
    }
    public double dfs(String src, String dest, Set<String> visited, Map<String, Map<String, Double>> graph) {
        if(!graph.containsKey(src)) return -1.0;
        if(graph.get(src).containsKey(dest)) return graph.get(src).get(dest);

        visited.add(src);
        for(Map.Entry<String, Double> nbr : graph.get(src).entrySet()){
            if(!visited.contains(nbr.getKey())){
                double weight = dfs(nbr.getKey(), dest, visited, graph);
                if(weight != -1.0){
                    return nbr.getValue() * weight;
                }
            }
        }
        return -1.0;
    }

    //union find
    public double[] calcEquationUF(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];

        UnionFind uf = new UnionFind();
        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get(i);
            uf.union(equation.get(0), equation.get(1), values[i]);
        }

        int idx = 0;
        for (List<String> query : queries) {

            Pair<String, Double> pair0 = uf.find(query.get(0));
            Pair<String, Double> pair1 = uf.find(query.get(1));

            res[idx] = -1d;
            if (pair0 != null && pair1 != null && pair0.getKey().equals(pair1.getKey()))
                res[idx] = pair0.getValue() / pair1.getValue();
            idx++;
        }
        return res;
    }

    public class Pair<T, U> {
        private T key;
        private U val;

        public Pair(T first, U second) {
            this.key = first;
            this.val = second;
        }


        public T getKey() {
            return key;
        }

        public U getValue() {
                return val;
        }
    }
    class UnionFind {
        Map<String, Pair<String, Double>> data = new HashMap<>();

        public Pair<String, Double> find(String x) {
            if (!data.containsKey(x)) return null;//new Pair<>(x, -1d);

            Pair<String, Double> group = data.get(x);

            if (!group.getKey().equals(x)) {
                Pair<String, Double> newGroup = find(group.getKey());
                group = new Pair<>(newGroup.getKey(), group.getValue() * newGroup.getValue());
                data.put(x, group); //update group
            }
            return group;
        }

        public void union(String x, String y, double value){
            if (!data.containsKey(x)) data.put(x, new Pair<>(x, 1d));
            if (!data.containsKey(y)) data.put(y, new Pair<>(y, 1d));

            Pair<String, Double> groupX = find(x);
            Pair<String, Double> groupY = find(y);

            if (groupX.getKey().equals(groupY.getKey())) return;

            Pair<String, Double> pair = new Pair<>(groupY.getKey(), value * groupY.getValue() / groupX.getValue());
            data.put(groupX.getKey(), pair);
        }
    }
}
