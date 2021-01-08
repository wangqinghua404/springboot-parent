package com.wqh.neo4j.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.neo4j.core.schema.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName ParentNode
 * @Author wqh
 * @Date 2021/1/7 17:09
 * @Description TODO
 * @Version 1.0
 */
@Getter
@NodeEntity(label = "ParentNode")
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@ToString
public class ParentNode {
    private @Id
    @GeneratedValue
    Long id;
    private @Property(name = "name")
    String name;
    private @Relationship(type = "RelationEdge")
    Set<RelationNode> sets = new HashSet<>();

    public ParentNode(String name) {
        this.name = name;
    }

    public void addRelation(SonNode sonNode, String name) {
        RelationNode relationNode = new RelationNode(this, name, sonNode);
        sets.add(relationNode);
        sonNode.getSets().add(relationNode);
    }
}
