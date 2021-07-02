package com.md.mysql;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

@Logger
@Component
@PropertySource("classpath:application.properties")
public class MySqlClient {
    private String username="root";
    private String password="ai1210";
    private String jdbc="jdbc:mysql://127.0.0.1:3306/test1?serverTimezone=GMT%2B8";
    private Map<Statement, Boolean> sessionPool = new HashMap<>();

    public MySqlClient() {
        loadDriver();
        createSessionPool(jdbc,username,password);
    }

    private Boolean loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void createSessionPool(String url, String name, String password) {
        try {
            Connection con = DriverManager.getConnection(url, name, password);

            for (int i = 0; i < 5; i++) {
                this.sessionPool.put(con.createStatement(), true);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public Statement getStatement() {
        for (int i = 0; i < 5; i++) {
            for (Statement session : this.sessionPool.keySet()) {
                if (this.sessionPool.get(session)) {
                    this.sessionPool.put(session, false);
                    return session;
                }
            }
//                等待3秒
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Boolean returnStatement(Statement statement) {
        this.sessionPool.put(statement,true);
        return true;
    }
}
