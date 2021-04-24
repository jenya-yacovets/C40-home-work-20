package by.tms.authCalculation.exception;

public class LoginIsBusy extends Exception{
    private String login;

    public LoginIsBusy(String login) {
        this.login = login;
    }

    public LoginIsBusy() {
    }

    @Override
    public String getMessage() {
        if(login != null) {
            return String.format("Login %s is busy", login);
        } else {
            return "Login is busy";
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
