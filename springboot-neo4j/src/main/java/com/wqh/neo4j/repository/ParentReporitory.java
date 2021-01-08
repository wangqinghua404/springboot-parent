package com.wqh.neo4j.repository;

import com.wqh.neo4j.entity.ParentNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentReporitory extends Neo4jRepository<ParentNode,Long> {
}