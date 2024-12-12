package org.example.module6;

import org.example.IModule;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Module6_2 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {},
        };
    }

    @Override
    public void execute(Object[][] data) {
        try {
            doMagic();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void doMagic() throws IOException {
        Scanner scanner = new Scanner(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("input_6_2.txt")));
//        Scanner scanner = new Scanner(Files.newInputStream(Paths.get("input.txt")));
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        Map<String, Cell> allCells = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == '.') {
                    allCells.put(i + ":" + j, new Cell(i + ":" + j));
                }
            }
        }
        int r = scanner.nextInt() - 1;
        int c = scanner.nextInt() - 1;
        int q = scanner.nextInt();
        scanner.nextLine();
        String commands = scanner.nextLine();

        Cell root = null;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!allCells.containsKey(i + ":" + j)) {
                    continue;
                }
                Cell current = allCells.get(i + ":" + j);
                if (i == r && j == c) {
                    root = current;
                }
                Cell up = allCells.get((i - 1) + ":" + j);
                Cell down = allCells.get((i + 1) + ":" + j);
                Cell left = allCells.get(i + ":" + (j - 1));
                Cell right = allCells.get(i + ":" + (j + 1));
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

        List<String> visited = new ArrayList<>();
        doPath(root, commands, 0, visited, DIRECTION.UP);
        System.out.println(visited.size());
    }

    private void recursiveFindNeighbours(Cell root, Map<String, Cell> allCells) {

    }

    private void doPath(Cell root, String commands, int index, List<String> visited, DIRECTION direction) {
        if (index == commands.length()) {
            if (!visited.contains(root.name)) {
                visited.add(root.name);
            }
            return;
        }
        char command = commands.charAt(index);
        if (command == 'R' || command == 'L') {
            DIRECTION newD = rotate(direction, command);
            doPath(root, commands, index+1, visited, newD);
        } else if (command == 'M') {
            Cell neighbour = root.neighbours.get(direction);
            if (neighbour != null) {
                if (!visited.contains(root.name)) {
                    visited.add(root.name);
                }
                doPath(neighbour, commands, index+1, visited, direction);
            } else {
                doPath(root, commands, index+1, visited, direction);
            }
        }
    }

    private DIRECTION rotate(DIRECTION direction, char command) {
        if (command == 'R') {
            switch (direction){
                case UP:
                    return DIRECTION.RIGHT;
                case RIGHT:
                    return DIRECTION.DOWN;
                case DOWN:
                    return DIRECTION.LEFT;
                case LEFT:
                    return DIRECTION.UP;
            }
        } else if (command == 'L') {
            switch (direction){
                case UP:
                    return DIRECTION.LEFT;
                case RIGHT:
                    return DIRECTION.UP;
                case DOWN:
                    return DIRECTION.RIGHT;
                case LEFT:
                    return DIRECTION.DOWN;

            }
        }

        return null;
    }

    private class Cell {
        public String name;
        public Map<DIRECTION, Cell> neighbours;
        public Cell(String name) {
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
