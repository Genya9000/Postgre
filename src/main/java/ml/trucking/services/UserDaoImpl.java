package ml.trucking.services;

import java.sql.*;

import java.util.List;
import java.util.Optional;

import ml.trucking.dao.CrudDao;
import ml.trucking.dao.UserDao;
import ml.trucking.model.User;
import org.apache.log4j.Logger;


public class UserDaoImpl implements CrudDao, UserDao {
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
    private final Connection connection;
    private User user;

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addUser(String name, String phone, String email, String password) {
        try {
            try (PreparedStatement st = connection
                    .prepareStatement("CREATE TABLE IF NOT EXISTS public.users\n" +
                            "(\n" +
                            "    id serial,\n" +
                            "    name text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
                            "    phone character(10) COLLATE pg_catalog.\"default\" NOT NULL,\n" +
                            "    email text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
                            "    password text COLLATE pg_catalog.\"default\" NOT NULL,\n" +
                            "    CONSTRAINT users_pkey PRIMARY KEY (id)\n" +
                            ")\n" +
                            "WITH (\n" +
                            "    OIDS = FALSE\n" +
                            ")\n" +
                            "TABLESPACE pg_default;\n" +
                            "\n" +
                            "ALTER TABLE public.users\n" +
                            "    OWNER to heqrgerlodfzxy; \n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "CREATE TABLE IF NOT EXISTS public.orders\n" +
                            "(\n" +
                            "    id SERIAL,\n" +
                            "    userid integer,\n" +
                            "    tipe text COLLATE pg_catalog.\"default\",\n" +
                            "    weight integer NOT NULL,\n" +
                            "    date text COLLATE pg_catalog.\"default\",\n" +
                            "    CONSTRAINT orders_pkey PRIMARY KEY (id),\n" +
                            "    CONSTRAINT \"orders_userId_fkey\" FOREIGN KEY (userid)\n" +
                            "        REFERENCES public.users (id) MATCH SIMPLE\n" +
                            "        ON UPDATE CASCADE\n" +
                            "        ON DELETE CASCADE\n" +
                            ")\n" +
                            "WITH (\n" +
                            "    OIDS = FALSE\n" +
                            ")\n" +
                            "TABLESPACE pg_default;\n" +
                            "\n" +
                            "ALTER TABLE public.orders\n" +
                            "    OWNER to heqrgerlodfzxy;\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "CREATE TABLE IF NOT EXISTS public.addresses\n" +
                            "(\n" +
                            "    id SERIAL,\n" +
                            "    orderid integer,\n" +
                            "    addresssent text COLLATE pg_catalog.\"default\",\n" +
                            "    deliveryaddress text COLLATE pg_catalog.\"default\",\n" +
                            "    distance integer NOT NULL,\n" +
                            "    CONSTRAINT addresses_pkey PRIMARY KEY (id),\n" +
                            "    CONSTRAINT \"addresses_orderId_fkey\" FOREIGN KEY (orderid)\n" +
                            "        REFERENCES public.orders (id) MATCH SIMPLE\n" +
                            "        ON UPDATE CASCADE\n" +
                            "        ON DELETE CASCADE\n" +
                            ")\n" +
                            "WITH (\n" +
                            "    OIDS = FALSE\n" +
                            ")\n" +
                            "TABLESPACE pg_default;\n" +
                            "\n" +
                            "ALTER TABLE public.addresses\n" +
                            "    OWNER to heqrgerlodfzxy;\n" +
                            "\n" +
                            "\n" +
                            "CREATE TABLE IF NOT EXISTS public.invoices\n" +
                            "(\n" +
                            "    id SERIAL,\n" +
                            "    orderid integer,\n" +
                            "    sum integer,\n" +
                            "    state text COLLATE pg_catalog.\"default\",\n" +
                            "    CONSTRAINT invoices_pkey PRIMARY KEY (id),\n" +
                            "    CONSTRAINT \"invoices_orderId_fkey\" FOREIGN KEY (orderid)\n" +
                            "        REFERENCES public.orders (id) MATCH SIMPLE\n" +
                            "        ON UPDATE CASCADE\n" +
                            "        ON DELETE CASCADE\n" +
                            ")\n" +
                            "WITH (\n" +
                            "    OIDS = FALSE\n" +
                            ")\n" +
                            "TABLESPACE pg_default;\n" +
                            "\n" +
                            "ALTER TABLE public.invoices\n" +
                            "OWNER to heqrgerlodfzxy;" +
                            "INSERT INTO users (name, phone, email, password) VALUES (?, ?, ?, ?)")) {
                st.setString(1, name);
                st.setString(2, phone);
                st.setString(3, email);
                st.setString(4, password);
                st.executeUpdate();
            }
        } catch (SQLException ex) {
            LOGGER.error("add user fail", ex);
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void deleteUser(String password) {
        try {
            try (PreparedStatement st = connection
                    .prepareStatement("DELETE FROM users  WHERE password = ?")) {
                st.setString(1, password);

                st.executeUpdate();
            }
        } catch (SQLException ex) {
            LOGGER.error("delete user fail", ex);
            throw new RuntimeException(ex);
        }

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getUser(String email, String password) {

        try {
            try (PreparedStatement st = connection.prepareStatement("SELECT * FROM users WHERE email=? AND password=?")) {
                st.setString(1, email);
                st.setString(2, password);

                try (ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        user = new User();

                        user.setId(rs.getInt(1));
                        user.setName(rs.getString(2));
                        user.setPhone(rs.getString(3));
                        user.setEmail(rs.getString(4));
                        user.setPassword(rs.getString(5));


                    }
                }
            }

            return user;
        } catch (SQLException ex) {
            LOGGER.error("user don't exist", ex);
            throw new RuntimeException(ex);
        }
    }


    @Override
    public int UserId(String email) {
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
