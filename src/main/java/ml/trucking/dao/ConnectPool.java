package ml.trucking.dao;


import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectPool {


    private static DbProperties dbProperties;
    private static BasicDataSource dataSource;

    static {

        dbProperties = new DbProperties();
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName(dbProperties.getDriver());
        dataSource.setUrl(dbProperties.getUrl());
        dataSource.setUsername(dbProperties.getUser());
        dataSource.setPassword(dbProperties.getPassword());
        dataSource.setMinIdle(0);
        dataSource.setMaxIdle(10);
        dataSource.setMaxTotal(20);
        dataSource.setInitialSize(5);


    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}