package ml.trucking.dao;

import ml.trucking.model.Order;


import java.sql.Date;
import java.util.List;

public interface OrderDao  extends CrudDao{

    void addOrder(Integer userId, String type, Integer weight, String date);
    void deleteOrder(int id);
     List<Order> getAll(int limit1, int limit2);


    Integer orderId();
}
