package ml.trucking.dao;

public interface InvoiceDao extends CrudDao {
    void updateInvoice(Integer orderId);
    void addInvoice(Integer orderId, int sum, String state);


}
