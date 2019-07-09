package ml.trucking.model;

public class Message {
    private Integer id;
    private String email;
    private String message;

    public Message() {
    }

    public Message(String email, String message) {
        this.email = email;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }


    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public void setMessage(String message) {
        this.message = message;


    }
}
