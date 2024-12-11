package org.example.module6;

import org.example.IModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Module6_1 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {},
        };
    }

    @Override
    public void execute(Object[][] data) {
//        for (int i = 0; i < data.length; i++) {
//            System.out.println("Dataset #" + i);
//            System.out.println("expected: " + data[i][2]);
//            System.out.println("actual: " + actual);
//        }
        try {
            doMagic3();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void doMagic() throws IOException {
        Scanner scanner = new Scanner(Files.newInputStream(Paths.get("input_6_1.txt")));
        int stopCount = scanner.nextInt();
        int pathCount = scanner.nextInt();
        scanner.nextLine();
        int[][] graph1 = new int[stopCount][stopCount];
        int[][] graph2 = new int[stopCount][stopCount];
        for (int i = 0; i < pathCount; i++) {
            int pathStopCount = scanner.nextInt();
            int[] stops = new int[pathStopCount];
            for (int j = 0; j < pathStopCount; j++) {
                int stop = scanner.nextInt();
                stops[j] = stop - 1;
                if (j == 0) {
                    continue;
                }
                int element = stop - 1;
                graph1[stops[j - 1]][element] = 1;
                graph1[element][stops[j - 1]] = 1;
                for (int k = j - 1; k >= 0; k--) {
                    graph2[stops[k]][element] = 1;
                    graph2[element][stops[k]] = 1;
                }
            }
            scanner.nextLine();
        }
        print(graph1);
        print(graph2);
    }

    private void doMagic2() throws IOException {
        Scanner scanner = new Scanner(Files.newInputStream(Paths.get("input_6_1.txt")));
        int stopCount = scanner.nextInt();
        int pathCount = scanner.nextInt();
        scanner.nextLine();
        int[][] graph1 = new int[stopCount][stopCount];
        int[][] graph2 = new int[stopCount][stopCount];
        for (int i = 0; i < pathCount; i++) {
            int pathStopCount = scanner.nextInt();
            int[] stops = new int[pathStopCount];
            String str = scanner.nextLine();
            int ii = 0;
            for (String s: str.trim().split(" ")) {
                stops[ii] = Integer.parseInt(s) - 1;
                ii++;
            }

            for (int j = 1; j < pathStopCount; j++) {
                graph1[stops[j - 1]][stops[j]] = 1;
                graph1[stops[j]][stops[j - 1]] = 1;
                for (int k = j - 1; k >= 0; k--) {
                    graph2[stops[k]][stops[j]] = 1;
                    graph2[stops[j]][stops[k]] = 1;
                }
            }
        }
        print(graph1);
        System.out.println();
        print(graph2);
    }

    private void doMagic3() throws IOException {
        Scanner scanner = new Scanner(Files.newInputStream(Paths.get("input_6_1.txt")));
        int stopCount = scanner.nextInt();
        int pathCount = scanner.nextInt();
        scanner.nextLine();
        int[][] graph1 = new int[stopCount][stopCount];
        int[][] graph2 = new int[stopCount][stopCount];

        for (int i = 0; i < pathCount; i++) {
            int pathStopCount = scanner.nextInt();
            int[] stops = new int[pathStopCount];
            String str = scanner.nextLine();
            int ii = 0;
            for (String s: str.trim().split(" ")) {
                stops[ii] = Integer.parseInt(s) - 1;
                ii++;
            }

            for (int j = 1; j < pathStopCount; j++) {
                graph1[stops[j - 1]][stops[j]] = 1;
                graph1[stops[j]][stops[j - 1]] = 1;
                for (int k = j - 1; k >= 0; k--) {
                    graph2[stops[k]][stops[j]] = 1;
                    graph2[stops[j]][stops[k]] = 1;
                }
            }
        }
        print(graph1);
        System.out.println();
        print(graph2);
    }

    private void  print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }


    }
}
