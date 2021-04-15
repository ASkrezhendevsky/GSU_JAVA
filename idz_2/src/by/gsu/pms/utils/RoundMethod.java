package by.gsu.pms.utils;

public enum RoundMethod {
    ROUND(){
        @Override
        public double round(double value) {
            return Math.round(value);
        }
    },
    FLOOR(){
        @Override
        public double round(double value) {
            return Math.floor(value);
        }
    },
    CEIL(){
        @Override
        public double round(double value) {
            return Math.ceil(value);
        }
    };

    public abstract double round(double value);
}
