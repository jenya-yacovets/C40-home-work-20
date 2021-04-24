package by.tms.authCalculation.entity;

import by.tms.authCalculation.config.TypeMessageEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FrontMessage {
    private TypeMessageEnum type;
    private String message;

    @Override
    public String toString() {
        return String.format("message=%s&type=%s", message, type.name());
    }
}
