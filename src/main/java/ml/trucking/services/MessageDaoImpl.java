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
                    .prepareStatement("CREATE TABLE IF NOT EXISTS public.messages\n" +
                            "(\n" +
                            "    id SERIAL,\n" +
                            "    email text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
                            "    message text COLLATE pg_catalog.\"default\",\n" +
                            "    CONSTRAINT messages_pkey PRIMARY KEY (id)\n" +
                            ")\n" +
                            "WITH (\n" +
                            "    OIDS = FALSE\n" +
                            ")\n" +
                            "TABLESPACE pg_default;\n" +
                            "\n" +
                            "ALTER TABLE public.messages\n" +
                            "    OWNER to heqrgerlodfzxy; INSERT INTO messages (email, message) VALUES (?, ?)")) {
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
