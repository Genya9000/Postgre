package ml.trucking.dao;

public interface AddressDao extends CrudDao {
    void addAddress(Integer orderId, String addressSent, String deliveryAddress, Integer distance);

void addressDelete(Integer id);
    int addressId(Integer orderId);
}
