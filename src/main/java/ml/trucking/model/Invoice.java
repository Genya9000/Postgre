package ml.trucking.model;

public class Invoice {
    private Integer id;
    private  Integer orderId;
    private Integer sum;
    private String state;

    public Invoice() {
    }

    public Invoice(Integer id) {
        this.id = id;
    }

    public Invoice(Integer id, Integer orderId, Integer sum, String state) {
        this.id = id;
        this.orderId = orderId;
        this.sum = sum;
        this.state = state;
    }

    public Invoice(Integer orderId, Integer sum, String state) {
        this.orderId = orderId;
        this.sum = sum;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", sum=" + sum +
                ", state='" + state + '\'' +
                '}';
    }
}
