package org.example.module7;

import org.example.IModule;

import java.util.*;

public class Module7_3 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {10, 1000, 3},
                new Object[] {2, 1, 1},
                new Object[] {100000, 1, 2}
        };
    }

    @Override
    public void execute(Object[][] data) {
        labyrinth();
    }

    public void labyrinth() {
        Scanner scanner = new Scanner(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("input_7_3.txt")));
//        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        Map<String, Node> nodes = new HashMap<>();
        Node start = null;
        Node finish = null;

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < line.length(); j++) {
                char ch = line.charAt(j);
                if (ch == '.') {
                    nodes.put(i + ":" + j, new Node(i + ":" + j));
                } else if (ch == 'S') {
                    start = new Node(i + ":" + j);
                    nodes.put(i + ":" + j, start);
                } else if (ch == 'F') {
                    finish = new Node(i + ":" + j);
                    nodes.put(i + ":" + j, finish);
                }
            }
        }

        doGraph(nodes, n, m);

        if (start == null || finish == null) {
            System.out.println(-1);
        } else {
            doPath(start, finish);
        }
    }

    private void doPath(Node start, Node finish) {
        Map<Node, Parent> visited = new HashMap<>();
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(start);
        visited.put(start, new Parent(start));
        boolean finished = false;

        while (!deque.isEmpty()) {
            Node current = deque.pop();
            if (current == finish) {
                finished = true;
                break;
            }

            for (Map.Entry<DIRECTION, Node> neighbour: current.neighbours.entrySet()) {
                if (null == neighbour.getValue()) {
                    continue;
                }
                if (!visited.containsKey(neighbour.getValue())) {
                    Parent parent = new Parent(current);
                    parent.direction = neighbour.getKey();
                    visited.put(neighbour.getValue(), parent);
                    deque.add(neighbour.getValue());
                }
            }
        }

        if (!finished) {
            System.out.println(-1);
            return;
        }
        List<DIRECTION> result = new ArrayList<>();
        Node current = finish;
        while (current != start) {
            result.add(visited.get(current).direction);
            current = visited.get(current).parent;
        }
        System.out.println(result.size());
        for (int i = result.size() - 1; i >=0; i--) {
            System.out.print(result.get(i).name().charAt(0));
        }
    }

    private void doGraph(Map<String, Node> nodes, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!nodes.containsKey(i + ":" + j)) {
                    continue;
                }
                Node current = nodes.get(i + ":" + j);
                Node up = nodes.get((i - 1) + ":" + j);
                Node down = nodes.get((i + 1) + ":" + j);
                Node left = nodes.get(i + ":" + (j - 1));
                Node right = nodes.get(i + ":" + (j + 1));
                if (null != up) {
                    current.neighbours.replace(DIRECTION.UP, up);
                }
                if (null != down) {
                    current.neighbours.replace(DIRECTION.DOWN, down);
                }
                if (null != left) {
                    current.neighbours.replace(DIRECTION.LEFT, left);
                }
                if (null != right) {
                    current.neighbours.replace(DIRECTION.RIGHT, right);
                }
            }
        }
    }

    private class Parent {
        public Node parent;
        public DIRECTION direction;
        public Parent(Node parent) {
            this.parent = parent;
            direction = null;
        }
    }

    private class Node {
        public String name;
        public Map<DIRECTION, Node> neighbours;
        public Node(String name) {
            this.name = name;
            neighbours = new HashMap<>();
            neighbours.put(DIRECTION.UP, null);
            neighbours.put(DIRECTION.RIGHT, null);
            neighbours.put(DIRECTION.DOWN, null);
            neighbours.put(DIRECTION.LEFT, null);
        }
    }

    private enum DIRECTION {
        UP,
        RIGHT,
        DOWN,
        LEFT
    }
}
