package by.tms.authCalculation.servise;

import by.tms.authCalculation.dao.DAO;
import by.tms.authCalculation.dao.InMemoryDAO;
import by.tms.authCalculation.entity.User;
import by.tms.authCalculation.exception.*;

public class UserService {
    private DAO dao = InMemoryDAO.getInstance();

    public void addUser(User user) throws LoginIsBusy {

        try {
            dao.getUserByLogin(user.getLogin());
            throw new LoginIsBusy(user.getLogin());
        } catch (UserNotFoundException e) {
            dao.createUser(user);
        }
    }

    public User getUser(User user) throws UserNotFoundException, ParametersNotPassedException {

        User userByLogin = dao.getUserByLogin(user.getLogin());

        if(userByLogin.getPassword().equals(user.getPassword())) {
            return userByLogin;
        }
        throw new UserNotFoundException();
    }

    public User updateName(User user, String newName) throws FieldNotChangedException, UserNotFoundException {
        if(user.getName().equals(newName)) {
            throw new FieldNotChangedException();
        }
        return dao.updateNameUser(user.getId(), newName);
    }

    public User updatePassword(User user, String[] passwords) throws FieldNotChangedException, InvalidPasswordException, UserNotFoundException {
        if(!user.getPassword().equals(passwords[0])) {
            throw new InvalidPasswordException();
        }
        if(user.getPassword().equals(passwords[1])) {
            throw new FieldNotChangedException();
        }

        return dao.updatePasswordUser(user.getId(), passwords[1]);
    }
}
