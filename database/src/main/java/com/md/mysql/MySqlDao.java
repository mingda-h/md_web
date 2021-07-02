package com.md.mysql;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@ComponentScan(basePackages = {"com.md.mysql"})
@Component
public class MySqlDao {
    @Autowired
    private MySqlClient mySqlClient;



    public void findByName(String name) {
        try {
            String sql = String.format("select * from use_info where user = '%s';",name);
            Statement statement = mySqlClient.getStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
            }
            mySqlClient.returnStatement(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
