package com.md;

import com.md.infra.neo4jDaoInfra;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.neo4j.driver.v1.*;
import static org.neo4j.driver.v1.Values.parameters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.Map;


@ComponentScan(basePackages = {"com.md"})
@Component
public class Neo4jDao {

    @Autowired
    private Neo4jClient neo4jClient;

    public Boolean create(Map<String,String>properties){
        return null;
    }
    public Boolean delete(String ID,String lable){
        String cypher = String.format("MATCH (n) WHERE id(n)=%s DETACH DELETE n",ID);
        this.operateCypher(cypher);
        return true;
    }
    public String query(String ID){
        return null;
    }
    public Boolean update(String ID){
        return null;
    }


    public List<Record> operateCypher (String cypher){
        List<Record> recordList = new LinkedList<>();
        Session session = neo4jClient.getSession();
        StatementResult result = session.run(cypher);
        while ( result.hasNext() )
        {
            Record record = result.next();
            recordList.add(record);
        }
        return recordList;
    }




    public void testConnect(){

        Session session1 = neo4jClient.getSession();
        Session session2 = neo4jClient.getSession();
        session1.run( "CREATE (a:Person {name: {name}, title: {title}})",
                parameters( "name", "Arthur001", "title", "King001" ) );


        StatementResult result = session2.run( "MATCH (a:Person) WHERE a.name = {name} " +
                        "RETURN a.name AS name, a.title AS title",
                parameters( "name", "Arthur001" ) );
        while ( result.hasNext() )
        {
            Record record = result.next();
            System.out.println( record.get( "title" ).asString() + " " + record.get( "name" ).asString() );
        }
        neo4jClient.ReturnSession(session1);
        neo4jClient.ReturnSession(session2);
//        session2.close();
//        driver.close();
    }
}
