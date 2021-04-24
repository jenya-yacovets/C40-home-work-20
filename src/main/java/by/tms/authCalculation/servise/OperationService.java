package by.tms.authCalculation.servise;

import by.tms.authCalculation.dao.DAO;
import by.tms.authCalculation.dao.InMemoryDAO;
import by.tms.authCalculation.entity.Operation;
import by.tms.authCalculation.entity.User;

import java.util.List;

public class OperationService {

    private DAO dao = InMemoryDAO.getInstance();

    public void addOperation(Operation operation){
        dao.createOperation(operation);
    }

    public List<Operation> getAllOperationUser(User user) {
        return dao.getAllOperationUser(user.getId());
    }
}
