package com.md.impl;


import com.md.Neo4jDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

//加上这两个注解才能正确的注入
@SpringBootTest
@RunWith(SpringRunner.class)

@ComponentScan(basePackages = "com.md")
@Configuration
public class neo4JDaoTest {
    @Autowired
    private Neo4jDao neo4jDao;
    @Value("${neo4j.username}")
    private String username ;
    @Test
    public void testConnect() {
        System.out.println(username);
        neo4jDao.testConnect();
    }

}
