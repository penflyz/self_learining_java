package com.penflyz;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Penflyz
 * @time 2021/9/14 10:42
 */

public class JdbcEx01 {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        new Ex02().ex02();
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/penflyz";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "penflyz");

        DriverManager.registerDriver(driver);
        Connection connect = driver.connect(url, properties);

        String sql = "insert into actor value(null,'刘德华','男','1997-10-28','110')";
        Statement statement = connect.createStatement();
        int i = statement.executeUpdate(sql);
        System.out.println(i > 0 ? "修改成功" : "修改失败");

        statement.close();
        connect.close();
    }
}

class Ex02 {
    public void ex02() throws IOException, ClassNotFoundException, SQLException {
     Properties properties = new Properties();
     properties.load(new FileInputStream("src//mysql.properties"));
     String user = properties.getProperty("user");
     String password = properties.getProperty("password");
     String url = properties.getProperty("url" );
     String driver = properties.getProperty("driver");

        Class.forName(driver);
     Connection connection = DriverManager.getConnection(url, user, password);
     System.out.println(connection);
    }
}

