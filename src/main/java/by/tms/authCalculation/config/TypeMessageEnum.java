package by.tms.authCalculation.config;

public enum TypeMessageEnum {
    INFO {
        @Override
        public boolean success() {
            return true;
        }
    },
    WARN {
        @Override
        public boolean success() {
            return false;
        }
    };
    public abstract boolean success();
}
