package com.try_hard.neo4jcodegraph;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
@NodeEntity
public class Employee {
    @GraphId
    private Long id;
    private String name;
    private String college;
    private String address;

    public Employee(String name, String college, String address) {
        this.name = name;
        this.college = college;
        this.address = address;
    }

    public Employee(){}

    @Override
    public String toString() {
        return String.format("Employee[id=%s, Name='%s', College='%s' , Place=%s]", id,
                name, college,address);
    }

}
