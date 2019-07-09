package ml.trucking.services;

import ml.trucking.dao.CrudDao;
import ml.trucking.dao.OrderDao;

import ml.trucking.model.Order;
import org.apache.log4j.Logger;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderDaoImpl implements CrudDao, OrderDao {
    private static final Logger LOGGER = Logger.getLogger(OrderDaoImpl.class);
    private static Order order;

    private final Connection connection;
    public OrderDaoImpl(Connection connection){
        this.connection = connection;
    }
    @Override
    public void addOrder(Integer userId, String type, Integer weight, String date) {
        try {
            try (PreparedStatement st = connection
                    .prepareStatement("INSERT INTO orders (userid, tipe, weight, date) VALUES (?, ?, ?, ?) returning id")) {
                st.setInt(1, userId);
                st.setString(2, type);
                st.setInt(3, weight);
                st.setString(4, date);
                //st.executeUpdate();
                ResultSet rs = st.executeQuery();
                while(rs.next()){
                    order = new Order();
                    order.setId(rs.getInt(1));
                    LOGGER.info("orderId finded");

                }
                System.out.println("order ok");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteOrder(int id) {

    }

    @Override
    public  List<Order> getAll(int limit1, int limit2) {
List<Order> list = new ArrayList<>();

        try {
            try (PreparedStatement st = connection.prepareStatement("SELECT * FROM orders LIMIT ? offset ?")) {
                st.setInt(1, limit1);
                st.setInt(2, limit2);

                try (ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        order = new Order();

                        order.setId(rs.getInt(1));
                        order.setUserId(rs.getInt(2));
                        order.setType(rs.getString(3));
                        order.setWeight(rs.getInt(4));
                        order.setDate(rs.getString(5));
                        list.add(order);

                    }
                }
            }

            return list;
        } catch (SQLException ex) {
            LOGGER.error("user don't exist", ex);
            throw new RuntimeException(ex);
        }
    }



    @Override
    public Integer orderId() {
        return order.getId();
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
