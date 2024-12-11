package org.example.module6;

import org.example.IModule;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class Module6_3 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {},

        };
    }

    @Override
    public void execute(Object[][] data) {
        List<List<String>> asd = Arrays.asList(
                Arrays.asList("MUC","LHR"),
                Arrays.asList("JFK","MUC"),
                Arrays.asList("SFO","SJC"),
                Arrays.asList("LHR","SFO")
        );
        List<String> res = Arrays.asList("JFK","MUC","LHR","SFO","SJC");

        for (int i = 0; i < data.length; i++) {
            System.out.println("Dataset #" + i);
            System.out.println("in: " + data[i][0]);
            System.out.println("expected: " + data[i][1]);
//            System.out.println("actual: " + actual);
        }
//        try {
//            doMagic();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    private void doMagic() throws IOException {
        Scanner scanner = new Scanner(Files.newInputStream(Paths.get("input_6_2.txt")));
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();


    }
}
