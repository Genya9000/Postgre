package ml.trucking.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class DbProperties {
    private String url;
    private String user;
    private String password;
    private String driver;

    public DbProperties() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("db.properties");

        Properties props = new Properties();
        try {
            props.load(is);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }

        url = props.getProperty("db.url");
        user = props.getProperty("db.user");
        password = props.getProperty("db.password");
        driver = props.getProperty("jdbc.driver");
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getDriver() {
        return driver;
    }
}