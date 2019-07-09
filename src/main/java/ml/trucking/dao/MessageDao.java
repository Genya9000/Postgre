package ml.trucking.dao;

public interface MessageDao extends CrudDao {
    void addMessage(String email, String message);
}
