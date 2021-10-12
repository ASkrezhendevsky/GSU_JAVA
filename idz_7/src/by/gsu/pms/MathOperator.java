package by.gsu.pms;

public enum MathOperator {
    SUM{
        @Override
        public long doOperation(long a, long b){
            return a + b;
        }
        public long getInitialValue(){
            return 0;
        }
    },
    MUL{
        @Override
        public long doOperation(long a, long b){
            return a * b;
        }
        public long getInitialValue(){
            return 1;
        }
    },
    SUB{
        @Override
        public long doOperation(long a, long b){
            return a - b;
        }
        public long getInitialValue(){
            return 0;
        }
    };

    public abstract long doOperation(long a, long b);
    public abstract long getInitialValue();

    public static MathOperator parse(String line){
        return valueOf(line.toUpperCase());
    }
}
