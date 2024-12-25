package org.example.module8;

import org.example.IModule;

import java.util.*;
import java.util.stream.Collectors;

public class Module8_5 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {4, new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4, 3},
                new Object[] {5, new int[][]{{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}}, 2, 0},
        };
    }

    @Override
    public void execute(Object[][] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Dataset #" + i);
            int actual = findTheCity((int)data[i][0], (int[][])data[i][1], (int)data[i][2]);
            System.out.println("expected: " + (int)data[i][3]);
            System.out.println("actual: " + actual);
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            int weight = edges[i][2];
            graph.get(a).add(new Edge(b, weight));
            graph.get(b).add(new Edge(a, weight));
        }

        List<List<Integer>> almost = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> dist = dijkstra(i, graph).stream().filter((distance) -> distance <= distanceThreshold).collect(Collectors.toList());
            almost.add(new ArrayList<>(Arrays.asList(i, dist.size() - 1)));
        }

        return almost.stream().sorted(( i1, i2) -> Integer.compare(i2.get(1), i1.get(1))).collect(Collectors.toList()).getLast().get(0);
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
