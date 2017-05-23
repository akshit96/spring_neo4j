package com.try_hard.neo4jcodegraph;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SuppressWarnings("deprecation")
@Service
@Transactional
public class EmployeeService implements InitializingBean {
    @Autowired EmployeeRepo repository;

    public void add_Employee(Employee employee) {
        this.repository.save(employee);
    }

    public void add_Relationship(String mentor, String mentee){
        this.repository.addrelation(mentor,mentee);
    }

 //   @Override
    public void afterPropertiesSet() throws Exception {

    }

    public List<String> findByName(String name) {
        return this.repository.getmentors(name);
    }
}
