package com.try_hard.neo4jcodegraph;
import java.util.Collection;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;



@RelationshipEntity(type = "IS_MENTOR_OF")
public class Relation {
    @GraphId
    Long id;
    Collection<String> roles;

    @StartNode
    Employee mentor;

    @EndNode
    Employee mentee;

    public Collection<String> getRoles() {
        return roles;
    }

    public Employee getPerson() {
        return mentor;
    }
}
