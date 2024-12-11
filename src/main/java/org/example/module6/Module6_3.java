package org.example.module6;

import org.example.IModule;

import java.util.*;
import java.util.stream.Collectors;

public class Module6_3 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {},

        };
    }

    @Override
    public void execute(Object[][] data) {
        List<List<String>> input1 = new ArrayList<>(Arrays.asList(
                Arrays.asList("MUC","LHR"),
                Arrays.asList("JFK","MUC"),
                Arrays.asList("SFO","SJC"),
                Arrays.asList("LHR","SFO")
        ));
        List<String> expected1 = new ArrayList<>(Arrays.asList("JFK","MUC","LHR","SFO","SJC"));
        List<List<String>> input2 = new ArrayList<>(Arrays.asList(
                Arrays.asList("JFK","SFO"),
                Arrays.asList("JFK","ATL"),
                Arrays.asList("SFO","ATL"),
                Arrays.asList("ATL","JFK"),
                Arrays.asList("ATL","SFO")
        ));
        List<String> expected2 = new ArrayList<>(Arrays.asList("JFK","ATL","JFK","SFO","ATL","SFO"));
        List<List<String>> input3 = new ArrayList<>(Arrays.asList(
                Arrays.asList("JFK","KUL"),
                Arrays.asList("JFK","NRT"),
                Arrays.asList("NRT","JFK")
        ));
        List<String> expected3 = new ArrayList<>(Arrays.asList("JFK","NRT","JFK","KUL"));
        List<List<String>> input4 = new ArrayList<>(Arrays.asList(
                Arrays.asList("EZE","AXA"),
                Arrays.asList("TIA","ANU"),
                Arrays.asList("ANU","JFK"),
                Arrays.asList("JFK","ANU"),
                Arrays.asList("ANU","EZE"),
                Arrays.asList("TIA","ANU"),
                Arrays.asList("AXA","TIA"),
                Arrays.asList("TIA","JFK"),
                Arrays.asList("ANU","TIA"),
                Arrays.asList("JFK","TIA")
        ));
        List<String> expected4 = new ArrayList<>(Arrays.asList("JFK","ANU","EZE","AXA","TIA","ANU","JFK","TIA","ANU","TIA","JFK"));

        List<String> actual = findItinerary(input3);
        System.out.println("expected: " + expected3);
        System.out.println("actual: " + actual);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        tickets = tickets.stream().sorted(Comparator.comparing((List<String> list) -> list.get(1))).collect(Collectors.toList());

        Map<String, Node> nodes = new HashMap<>();
        Node graph = doGraph(new Node("JFK"), tickets, nodes);

        return doMagic(graph, tickets);
    }

    private List<String> doMagic(Node node, List<List<String>> tickets) {
        List<String> visited = new ArrayList<>();
        dfs(node, visited, tickets);
        return visited.reversed();
    }

    private void dfs(Node node, List<String> visited, List<List<String>> tickets) {
        for (Node neighbor: node.neighbours) {
            List<String> pair = Arrays.asList(node.name, neighbor.name);
            if (tickets.contains(pair)) {
                tickets.remove(pair);
                dfs(neighbor, visited, tickets);
            }
        }
        visited.add(node.name);
    }

    private Node doGraph(Node node, List<List<String>> tickets, Map<String, Node> nodes) {
        nodes.put(node.name, node);

        for (List<String> pair: tickets) {
            if (!pair.get(0).equals(node.name)) {
                continue;
            }

            if (nodes.containsKey(pair.get(1))) {
                node.neighbours.add(nodes.get(pair.get(1)));
            } else {
                Node arrival = new Node(pair.get(1));
                node.neighbours.add(arrival);
                doGraph(arrival, tickets, nodes);
            }
        }

        return node;
    }

    private class Node {
        public String name;
        public List<Node> neighbours;
        public Node(String name) {
            this.name = name;
            neighbours = new ArrayList<>();
        }
    }

    private void printGraph(Node node) {
        Map<String, Node> visited = new HashMap<>();
        recursivePrintGraph(node, visited);
    }

    private void recursivePrintGraph(Node node, Map<String, Node> visited) {
        printNode(node);
        visited.put(node.name, node);
        for (Node neighbor: node.neighbours) {
            if (visited.containsKey(neighbor.name)) {
                continue;
            }
            recursivePrintGraph(neighbor, visited);
        }
    }

    private void printNode(Node node) {
        System.out.println("Node: " + node.name);
        for (Node p: node.neighbours) {
            System.out.print(" " + p.name);
        }
        System.out.println();
    }
}
