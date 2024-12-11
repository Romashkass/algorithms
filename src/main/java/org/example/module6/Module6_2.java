package org.example.module6;

import org.example.IModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Module6_2 implements IModule {
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
            doMagic();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void doMagic() throws IOException {
        Scanner scanner = new Scanner(Files.newInputStream(Paths.get("input_6_2.txt")));
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();


    }
}
