package by.gsu.pms;

public class ThreadGenerator {
    private final int threadNum;
    private final MathOperator operator;
    private final Calculator[] calculators;
    private final long a;
    private boolean resultReady = false;

    public ThreadGenerator(int threadNum, long a, MathOperator operator) {
        this.threadNum = threadNum;
        this.operator = operator;
        calculators = new Calculator[threadNum];
        this.a = a;
    }

    public void execute() {
        long subtaskRange = a / threadNum;

        for (int i = 0; i < threadNum; i++) {
            long subtaskStart = i * subtaskRange + 1;
            long subtaskEnd = i * subtaskRange + subtaskRange;

            if ( i == threadNum - 1){
                subtaskEnd = a;
            }

            calculators[i] = new Calculator(subtaskStart, subtaskEnd);

            Thread thread = new Thread(calculators[i]);
            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resultReady = true;
        }
    }

    public long getResult() {
        if (!resultReady) {
            throw new IllegalStateException("execute() must be executed before getResult() excecution");
        }
        long result = operator.getInitialValue();
        for (Calculator calculator : calculators) {
            result = operator.doOperation(result, calculator.getResult());
        }
        return result;
    }
}
