package ml.trucking.model;

import java.util.Date;

public class Order {
    private static Integer id;
    private Integer userId;
    private String type;
    private Integer weight;
    private String date;

    public Order() {
    }



    public Order(Integer id, Integer userId, String type, Integer weight, String date) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.weight = weight;
        this.date = date;
    }

    public Order(Integer userId, String type, Integer weight, String date) {
        this.userId = userId;
        this.type = type;
        this.weight = weight;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                ", date=" + date +
                '}';
    }
}
