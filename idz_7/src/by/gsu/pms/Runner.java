package by.gsu.pms;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        long a = 15;
        int threadNum = 4;
        MathOperator operator = MathOperator.SUM;

        try (Scanner in = new Scanner(System.in)) {
            System.out.println(ConsoleMessages.ENTER_A);
            a = in.nextInt();

            System.out.println(ConsoleMessages.ENTER_THREAD_NUM);
            threadNum = in.nextInt();

            System.out.println(ConsoleMessages.ENTER_OPERATION);
            operator = MathOperator.parse(in.next());
        }

        ThreadGenerator generator = new ThreadGenerator(threadNum, a, operator);
        generator.execute();
        System.out.println("Multithread result = " + generator.getResult());
    }
}