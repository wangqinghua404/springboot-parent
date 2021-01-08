package com.wqh.neo4j.repository;

import com.wqh.neo4j.entity.Node;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeReporistory extends Neo4jRepository<Node,Long> {
}
