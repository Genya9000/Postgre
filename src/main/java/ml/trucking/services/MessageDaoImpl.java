package ml.trucking.services;

import ml.trucking.dao.CrudDao;
import ml.trucking.dao.MessageDao;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MessageDaoImpl implements MessageDao, CrudDao {
    private static final Logger LOGGER = Logger.getLogger(MessageDaoImpl.class);
    private final Connection connection;
public MessageDaoImpl(Connection connection){this.connection=connection;}

    @Override
    public void addMessage(String email, String message) {
        try {
            try (PreparedStatement st = connection
                    .prepareStatement("INSERT INTO messages (email, message) VALUES (?, ?)")) {
                st.setString(1, email);
                st.setString(2, message);

                st.executeUpdate();
            }
        } catch (SQLException ex) {
            LOGGER.error("add message fail", ex);
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Optional find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Object model) {

    }

    @Override
    public void update(Object model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List findAll() {
        return null;
    }
}
