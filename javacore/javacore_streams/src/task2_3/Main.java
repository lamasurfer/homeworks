package task2_3;

import task2_3.testers.TestCase;
import task2_3.testers.Tester;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/task2_3/results.txt");
        PrintStream toFile = new PrintStream(new FileOutputStream(file, true));
        System.setOut(toFile);


        TestCase singleTestCase = new TestCase(10_000_000);
        Tester tester = new Tester("Задание 1");
        tester.performTestOn(singleTestCase);
        tester.showResults();


        Tester testerSerial = new Tester("Задание 1, больше случаев");

        for (int i = 0; i < 10; i++) {
            testerSerial.performTestOn(new TestCase(10_000_000));
        }
        testerSerial.showResults();


        Tester cycleTester = new Tester("Задание 2");
        int[] sampleSize = new int[]{100, 1_000, 10_000, 100_000, 1_000_000, 10_000_000};

        for (int i : sampleSize) {

            TestCase testCase = new TestCase(i);
            cycleTester.performTestOn(testCase);

        }
        cycleTester.showResults();

    }
}


