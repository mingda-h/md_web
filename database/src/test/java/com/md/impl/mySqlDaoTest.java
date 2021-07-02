package com.md.impl;

import com.md.mysql.MySqlDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ComponentScan(basePackages = "com.md.mysql")
@Configuration
public class mySqlDaoTest {
    @Autowired
    private MySqlDao mySqlDao;

    @Test
    public void testConnect(){
        mySqlDao.findByName("明达");
    }
}
