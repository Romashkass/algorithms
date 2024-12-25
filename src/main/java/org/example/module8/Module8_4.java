package org.example.module8;

import org.example.IModule;

import java.util.*;

public class Module8_4 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2, 2},
                new Object[] {new int[][]{{1, 2, 1}}, 2, 1, 1},
                new Object[] {new int[][]{{1, 2, 1}}, 2, 2, -1}
        };
    }

    @Override
    public void execute(Object[][] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Dataset #" + i);
            int actual = networkDelayTime((int[][])data[i][0], (int)data[i][1], (int)data[i][2]);
            System.out.println("expected: " + (int)data[i][3]);
            System.out.println("actual: " + actual);
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            int a = times[i][0] - 1;
            int b = times[i][1] - 1;
            int weight = times[i][2];
            graph.get(a).add(new Edge(b, weight));
        }
        List<Integer> test = dijkstra(k - 1, graph);
        int result = test.stream().max(Comparator.comparingInt(element -> element)).get();
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }

    private List<Integer> dijkstra(int start, List<List<Edge>> graph) {
        boolean[] visited = new boolean[graph.size()];
        List<Integer> distances = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            distances.add(Integer.MAX_VALUE);
        }
        distances.set(start, 0);
        for (int i = 0; i < graph.size(); i++) {
            int nearest = -1;
            for (int j = 0; j < graph.size(); j++) {
                if (!visited[j] && (nearest == -1 || distances.get(j) < distances.get(nearest))) {
                    nearest = j;
                }
            }

            visited[nearest] = true;

            if (distances.get(nearest) == Integer.MAX_VALUE) {
                break;
            }

            for (int j = 0; j < graph.get(nearest).size(); j++) {
                Edge edge = graph.get(nearest).get(j);
                if (distances.get(nearest) + edge.weight < distances.get(edge.to)) {
                    distances.set(edge.to, distances.get(nearest) + edge.weight);
                }
            }
        }

        return distances;
    }

    private class Edge {
        public int to;
        public int weight;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
