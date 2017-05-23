package com.try_hard.neo4jcodegraph;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;


public interface  MentorRelationRepo extends GraphRepository<Employee>{


}