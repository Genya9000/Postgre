package ml.trucking.services;

import ml.trucking.dao.InvoiceDao;

import ml.trucking.model.Order;
import ml.trucking.model.State;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class InvoiceDaoImpl implements InvoiceDao {
    private static final Logger LOGGER = Logger.getLogger(InvoiceDaoImpl.class);
    private final Connection connection;

    public InvoiceDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void updateInvoice(Integer orderId) {

        try {
            try (PreparedStatement st = connection.prepareStatement("UPDATE invoices SET state = ? WHERE orderId = ?");
        ) {
                st.setString(1, String.valueOf(State.paid));
                st.setInt(2, orderId);

                st.executeUpdate();
            }
        } catch (SQLException ex) {
            LOGGER.error("update invoice fail", ex);
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void addInvoice(Integer orderId, int sum, String state) {
        try {
            try (PreparedStatement st = connection
                    .prepareStatement("INSERT INTO invoices (orderid, sum, state) VALUES (?, ?, ?)")) {
                st.setInt(1, orderId);
                st.setInt(2, sum);
                st.setString(3, state);

                st.executeUpdate();
            }
        } catch (SQLException ex) {
            LOGGER.error("add invoice fail", ex);
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
