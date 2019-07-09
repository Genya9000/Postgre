package ml.trucking.services;

import ml.trucking.dao.AddressDao;
import ml.trucking.dao.CrudDao;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AddressDaoImpl implements AddressDao, CrudDao {
    private static final Logger LOGGER = Logger.getLogger(AddressDaoImpl.class);
    private final Connection connection;
    public AddressDaoImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void addAddress(Integer orderId, String addressSent, String deliveryAddress, Integer distance) {
        try {
            try (PreparedStatement st = connection
                    .prepareStatement("INSERT INTO addresses (orderid, addressSent, deliveryAddress, distance) VALUES (?, ?, ?, ?)")) {
                st.setInt(1, orderId);
                st.setString(2, addressSent);
                st.setString(3, deliveryAddress);
                st.setInt(4, distance);
                st.executeUpdate();
            }
        } catch (SQLException ex) {
            LOGGER.error("add address fail", ex);
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void addressDelete(Integer id) {

    }

    @Override
    public int addressId(Integer orderId) {
        return 0;
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
