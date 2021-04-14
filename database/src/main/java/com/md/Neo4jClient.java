package com.md;

import org.neo4j.driver.v1.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Component
public class Neo4jClient {
    @Value("${neo4j.username}")
    private String username = "neo4j";
    @Value("${neo4j.password}")
    private final String password = "123456";
    @Value("${neo4j.uri}")
    private final String uri = "bolt://192.168.1.108:7687";

    private Map<Session,Boolean> sessionPool  = new HashMap<>();

    public Neo4jClient(String uri,String username,String password){
        for(int i=0;i<5;i++){
            Driver driver = GraphDatabase.driver(uri, AuthTokens.basic(username,password));
            this.sessionPool.put(driver.session(),true);
        }
    }
    public Neo4jClient(){
        Driver driver = GraphDatabase.driver(uri, AuthTokens.basic(username,password));
        for(int i=0;i<5;i++){
            Session session = driver.session();
            this.sessionPool.put(session,true);
        }
    }

    public Session getSession(){
            for(int i=0;i<5;i++){
                for(Session session :this.sessionPool.keySet()){
                    if(this.sessionPool.get(session)){
                        this.sessionPool.put(session,false);
                        return session;
                    }
                }
//                等待3秒
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        return null;
    }

    public void ReturnSession(Session session){
        this.sessionPool.put(session,true);
    }
}
