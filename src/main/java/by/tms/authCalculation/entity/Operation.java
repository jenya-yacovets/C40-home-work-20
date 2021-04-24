package by.tms.authCalculation.entity;

import by.tms.authCalculation.config.OperationEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation {
    private int id;
    private User user;
    private double num1;
    private double num2;
    private OperationEnum operation;

    public Operation(User user, double num1, double num2, OperationEnum operation) {
        this.user = user;
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
    }

    public double result() {
        return operation.action(num1, num2);
    }
}
