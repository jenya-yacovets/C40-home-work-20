package by.tms.authCalculation.exception;

public class ParametersNotPassedException extends Exception{
    private String param;

    public ParametersNotPassedException(String param) {
        this.param = param;
    }

    public ParametersNotPassedException() {
    }

    @Override
    public String getMessage() {
        if(param != null) {
            return String.format("The '%s' parameter was not passed", param);
        } else {
            return "Parameters not passed";
        }
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
