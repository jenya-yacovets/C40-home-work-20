package by.tms.authCalculation.dao;

import by.tms.authCalculation.entity.Operation;
import by.tms.authCalculation.entity.User;
import by.tms.authCalculation.exception.UserNotFoundException;

import java.util.List;

public interface DAO {
    int createUser(User user);
    User getUserByLogin(String login) throws UserNotFoundException;
    User updateNameUser(int id, String name) throws UserNotFoundException;
    User updatePasswordUser(int id, String password) throws UserNotFoundException;

    int createOperation(Operation operation);
    List<Operation> getAllOperationUser(int id);
}
