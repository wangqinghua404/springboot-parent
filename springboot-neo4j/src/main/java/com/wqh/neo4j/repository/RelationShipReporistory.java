package com.wqh.neo4j.repository;

import com.wqh.neo4j.entity.RelationShip;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationShipReporistory extends Neo4jRepository<RelationShip, Long> {
}
