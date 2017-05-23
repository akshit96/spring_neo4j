package com.try_hard.neo4jcodegraph;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeRepo extends GraphRepository<Employee> {
    public Employee findByName(String name);

    @Query("MATCH (a:Employee)-[:IS_MENTOR_OF]->(b:Employee) where  b.name = {mentee_name} RETURN a.name")
    List<String> getmentors(@Param("mentee_name") String mentee_name);

    @Query("MATCH (a:Employee),(b:Employee) where a.name = {mentor_name} AND b.name = {mentee_name} CREATE (a)-[r:IS_MENTOR_OF]->(b) RETURN a")
    Employee addrelation(@Param("mentor_name") String mentor_name, @Param("mentee_name") String mentee_name);

}
