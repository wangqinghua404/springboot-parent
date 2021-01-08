package com.wqh.neo4j.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.neo4j.core.schema.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName SonNode
 * @Author wqh
 * @Date 2021/1/7 17:11
 * @Description TODO
 * @Version 1.0
 */
@Getter
@NodeEntity(label = "SonNode")
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class SonNode {
    private @Id
    @GeneratedValue
    Long id;
    private @Property(name = "name")
    String name;
    private @Relationship(type = "RelationEdge", direction = "INCOMING")
    Set<RelationNode> sets = new HashSet<>();

    public SonNode(String name) {
        this.name = name;
    }
}
