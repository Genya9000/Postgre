package ml.trucking.model;

public class Address {
    private Integer id;
    private Integer orderId;
    private String addressSent;
    private String deliveryAddress;
    private String distance;

    public Address() {
    }

    public Address(Integer id) {
        this.id = id;
    }

    public Address(Integer id, Integer orderId, String addressSent, String deliveryAddress, String distance) {
        this.id = id;
        this.orderId = orderId;
        this.addressSent = addressSent;
        this.deliveryAddress = deliveryAddress;
        this.distance = distance;
    }

    public Address(Integer orderId, String addressSent, String deliveryAddress, String distance) {
        this.orderId = orderId;
        this.addressSent = addressSent;
        this.deliveryAddress = deliveryAddress;
        this.distance = distance;
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

    public String getAddressSent() {
        return addressSent;
    }

    public void setAddressSent(String addressSent) {
        this.addressSent = addressSent;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", addressSent='" + addressSent + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", distance='" + distance + '\'' +
                '}';
    }
}
