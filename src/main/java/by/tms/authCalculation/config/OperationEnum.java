package by.tms.authCalculation.config;

public enum OperationEnum {
    PLUS {
        @Override
        public double action(double num1, double num2) {
            return num1 + num2;
        }
        @Override
        public String getNameParam() {
            return "plus";
        }
        @Override
        public String getNameUser() {
            return "Сложение";
        }
    },
    MINUS {
        @Override
        public double action(double num1, double num2) {
            return num1 - num2;
        }
        @Override
        public String getNameParam() {
            return "minus";
        }
        @Override
        public String getNameUser() {
            return "Вычитание";
        }
    },
    MULTIPLY {
        @Override
        public double action(double num1, double num2) {
            return num1 * num2;
        }
        @Override
        public String getNameParam() {
            return "multiply";
        }
        @Override
        public String getNameUser() {
            return "Умножение";
        }
    },
    DIVIDE {
        @Override
        public double action(double num1, double num2) {
            return num1 / num2;
        }
        @Override
        public String getNameParam() {
            return "divide";
        }
        @Override
        public String getNameUser() {
            return "Деление";
        }
    };

    public abstract double action(double num1, double num2);
    public abstract String getNameParam();
    public abstract String getNameUser();
}
