package org.example.module6;

import org.example.IModule;

import java.util.*;

public class Module6_4 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {},

        };
    }

    @Override
    public void execute(Object[][] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Leetcode 133");
//            System.out.println("Dataset #" + i);
//            System.out.println("in: " + data[i][0]);
//            System.out.println("expected: " + data[i][1]);
//            System.out.println("actual: " + actual);
        }
    }

    public Node cloneGraph(Node node) {
        Map<Integer, Node> visited = new HashMap<>();
        if (null == node) {
            return null;
        }
        return recursiveClone(node, visited);
    }

    private Node recursiveClone(Node node, Map<Integer, Node> visited) {
        Node result = new Node(node.val);
        visited.put(result.val, result);
        for (Node neighbor: node.neighbors) {
            if (visited.containsKey(neighbor.val)) {
                result.neighbors.add(visited.get(neighbor.val));
                continue;
            }
            result.neighbors.add(recursiveClone(neighbor, visited));
        }
        return result;
    }

    private class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}